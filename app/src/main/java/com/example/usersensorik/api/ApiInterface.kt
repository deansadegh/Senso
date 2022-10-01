package com.example.myapplication.api

import com.sensorik.domain.model.user.SignInRequestPostDto
import com.example.usersensorik.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/v1/auth/login")
    suspend fun login(@Body signInRequestPostDto: SignInRequestPostDto): Response<LoginResponse>
}