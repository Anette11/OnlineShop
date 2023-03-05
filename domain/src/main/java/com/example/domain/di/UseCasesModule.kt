package com.example.domain.di

import com.example.domain.repository.UserRepository
import com.example.domain.use_cases.GetUserByFirstNameUseCase
import com.example.domain.use_cases.GetUserByIsLoggedInUseCase
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
    fun provideGetUserByFirstNameUseCase(
        userRepository: UserRepository
    ): GetUserByFirstNameUseCase = GetUserByFirstNameUseCase(userRepository = userRepository)

    @Provides
    @Singleton
    fun provideGetUserByIsLoggedInUseCase(
        userRepository: UserRepository
    ): GetUserByIsLoggedInUseCase = GetUserByIsLoggedInUseCase(userRepository = userRepository)


    @Provides
    @Singleton
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase = SaveUserUseCase(userRepository = userRepository)
}