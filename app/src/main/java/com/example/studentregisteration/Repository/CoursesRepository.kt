package com.example.registration.repository

import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {
//    lateinit var sessionManager: SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun courses(accessToken: String): Response<List<CoursesResponse>> =
        withContext(Dispatchers.IO){
//            var response = apiInterface.studentCourses(token="Bearer ${sessionManager.fetchAuthentication()}")
            var response = apiInterface.studentCourses((accessToken))
            return@withContext response
        }
    suspend fun enrol(accessToken: String): Response<EnrolmentResponse> =
        withContext(Dispatchers.IO){
            var enrol = apiInterface.enrol(accessToken)
            return@withContext enrol
        }
}
