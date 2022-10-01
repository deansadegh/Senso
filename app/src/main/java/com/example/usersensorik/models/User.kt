package com.example.usersensorik.models

data class User(
    val createdAt: String,
    val email: String,
    val id: String,
    val role: String,
    val status: String,
    val updatedAt: String,
    val verifiedAt: String
)