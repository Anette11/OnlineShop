package com.example.domain.di

import com.example.domain.repository.UserRepository
import com.example.domain.use_cases.GetUserUseCase
import com.example.domain.use_cases.SaveUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetUserUseCase(
        userRepository: UserRepository
    ): GetUserUseCase = GetUserUseCase(userRepository = userRepository)

    @Provides
    @Singleton
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase = SaveUserUseCase(userRepository = userRepository)
}