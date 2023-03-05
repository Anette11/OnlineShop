package com.example.domain.data

import android.net.Uri

data class User(
    val firstName: String,
    val lastName: String,
    val password: String,
    val imageUri: Uri?,
    val isLoggedIn: Boolean,
    val email: String
)