package com.example.data.repositories

import com.example.data.local.UserDao
import com.example.data.local.toUser
import com.example.data.local.toUserDbo
import com.example.domain.data.local.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override fun getUserByIsLoggedInFlow(isLoggedIn: Boolean): Flow<User?> =
        userDao.getUserByIsLoggedInFlow(isLoggedIn = isLoggedIn)
            .map { userDbo -> userDbo?.toUser() }
}