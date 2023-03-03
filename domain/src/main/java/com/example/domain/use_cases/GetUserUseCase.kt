package com.example.domain.use_cases

import com.example.domain.data.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(email: String): User? =
        userRepository.getUser(email = email)
}