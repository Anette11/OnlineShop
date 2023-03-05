package com.example.domain.use_cases

import com.example.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIsLoggedInFlow @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(isLoggedIn: Boolean) =
        userRepository.getUserByIsLoggedInFlow(isLoggedIn = isLoggedIn)
}