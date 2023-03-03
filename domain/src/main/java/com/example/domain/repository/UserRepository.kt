package com.example.domain.repository

import com.example.domain.data.User

interface UserRepository {

    suspend fun saveUser(user: User)

    fun getUser(email: String): User?
}