package com.example.myapplication.api

import com.example.usersensorik.models.ChangePasswordDto
import com.sensorik.domain.model.user.SignInRequestPostDto
import com.example.usersensorik.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/v1/auth/login")
    suspend fun login(@Body signInRequestPostDto: SignInRequestPostDto): Response<LoginResponse>
    @POST("/v1/auth/forget-password")
    suspend fun forgot(@Body signInRequestPostDto: SignInRequestPostDto): Response<LoginResponse>
    @POST("/v1/auth/set-password")
    suspend fun changePassword(@Body changePasswordDto: ChangePasswordDto): Response<LoginResponse>

}