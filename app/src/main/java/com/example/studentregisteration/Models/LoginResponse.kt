package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    var message: String,
    @SerializedName("access_token")var accessToken: String,
    @SerializedName("student_id")var studentId: String
)
