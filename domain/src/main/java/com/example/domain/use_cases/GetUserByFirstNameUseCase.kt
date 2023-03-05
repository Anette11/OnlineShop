package com.example.domain.use_cases

import com.example.domain.data.local.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByFirstNameUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(firstName: String): User? =
        userRepository.getUserByFirstName(firstName = firstName)
}