package com.example.domain.use_cases

import com.example.domain.data.local.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIsLoggedInUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(isLoggedIn: Boolean): User? =
        userRepository.getUserByIsLoggedIn(isLoggedIn = isLoggedIn)
}