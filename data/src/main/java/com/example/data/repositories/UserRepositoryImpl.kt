package com.example.data.repositories

import com.example.data.local.UserDao
import com.example.data.mappers.toUser
import com.example.data.mappers.toUserDbo
import com.example.domain.data.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun saveUser(user: User) =
        userDao.saveUser(user = user.toUserDbo())

    override fun getUserByFirstName(firstName: String): User? =
        userDao.getUserByFirstName(firstName = firstName)?.toUser()

    override fun getUserByIsLoggedIn(isLoggedIn: Boolean): User? =
        userDao.getUserByIsLoggedIn(isLoggedIn = isLoggedIn)?.toUser()
}