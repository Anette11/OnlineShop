package com.example.domain.repository

import com.example.data.local.user.UserDbo

interface UserRepository {

    suspend fun saveUser(user: UserDbo)

    fun getUser(email: String): UserDbo?
}