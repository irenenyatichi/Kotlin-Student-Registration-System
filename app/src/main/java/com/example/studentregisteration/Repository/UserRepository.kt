package com.example.studentregisteration.Repository

import com.example.studentregisteration.Api.ApiClient
import com.example.studentregisteration.Api.ApiInterface

class UserRepository {
    var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerUser()
}