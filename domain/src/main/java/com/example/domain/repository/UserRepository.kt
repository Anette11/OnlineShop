package com.example.domain.repository

import com.example.domain.data.local.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun saveUser(user: User)

    fun getUserByFirstName(firstName: String): User?

    fun getUserByIsLoggedIn(isLoggedIn: Boolean): User?

    fun getUserByIsLoggedInFlow(isLoggedIn: Boolean): Flow<User?>
}