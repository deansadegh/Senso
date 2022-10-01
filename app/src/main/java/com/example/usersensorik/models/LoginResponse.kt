package com.example.usersensorik.models

data class LoginResponse(
    val `data`: Data,
    val statusCode: Int,
    val success: Boolean,
    val timeStamp: String
)