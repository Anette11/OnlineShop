package com.example.domain.repository

import com.example.domain.data.User

interface UserRepository {

    suspend fun saveUser(user: User)

    fun getUserByEmail(email: String): User?

    fun getUserByFirstName(firstName: String): User?
}