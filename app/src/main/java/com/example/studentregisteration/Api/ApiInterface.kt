package com.example.studentregisteration.Api

import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/student/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):<RegistrationResponse>
}