package com.example.domain.data

data class User(
    val firstName: String,
    val lastName: String,
    val password: String,
    val imageUri: String? = null,
    val isLoggedIn: Boolean,
    val email: String
)