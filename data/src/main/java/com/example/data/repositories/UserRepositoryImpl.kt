package com.example.data.repositories

import com.example.data.local.UserDao
import com.example.data.local.user.UserDbo
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun saveUser(user: UserDbo) =
        userDao.saveUser(user = user)

    override fun getUser(email: String): UserDbo? =
        userDao.getUser(email = email)
}