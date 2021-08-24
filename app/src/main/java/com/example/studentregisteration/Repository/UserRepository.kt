package com.example.registration.repository

import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.LogInRequest
import com.example.registration.models.LogInResponse
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
                var response = apiInterface.registerStudent(registrationRequest)
                    return@withContext response
    }

    suspend fun login(logInRequest: LogInRequest):Response<LogInResponse> =
        withContext(Dispatchers.IO){
            var response = apiInterface.logInStudent(logInRequest)
            return@withContext response
        }
}
