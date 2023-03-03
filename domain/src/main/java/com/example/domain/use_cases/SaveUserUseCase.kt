package com.example.domain.use_cases

import com.example.data.mappers.toUserDbo
import com.example.domain.data.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) =
        userRepository.saveUser(user = user.toUserDbo())
}