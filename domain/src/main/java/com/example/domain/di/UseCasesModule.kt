package com.example.domain.di

import com.example.domain.repository.ProductRepository
import com.example.domain.repository.TradeRepository
import com.example.domain.repository.UserRepository
import com.example.domain.repository.WordsRepository
import com.example.domain.use_cases.*
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
    fun provideGetUserByIsLoggedInFlow(
        userRepository: UserRepository
    ): GetUserByIsLoggedInFlow = GetUserByIsLoggedInFlow(userRepository = userRepository)

    @Provides
    @Singleton
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase = SaveUserUseCase(userRepository = userRepository)

    @Provides
    @Singleton
    fun provideGetLatestUseCase(
        tradeRepository: TradeRepository
    ): GetLatestUseCase = GetLatestUseCase(tradeRepository = tradeRepository)

    @Provides
    @Singleton
    fun provideGetFlashSaleUseCase(
        tradeRepository: TradeRepository
    ): GetFlashSaleUseCase = GetFlashSaleUseCase(tradeRepository = tradeRepository)

    @Provides
    @Singleton
    fun provideGetWordsUseCase(
        wordsRepository: WordsRepository
    ): GetWordsUseCase = GetWordsUseCase(wordsRepository = wordsRepository)

    @Provides
    @Singleton
    fun provideGetProductDetailsUseCase(
        productRepository: ProductRepository
    ): GetProductDetailsUseCase = GetProductDetailsUseCase(productRepository = productRepository)
}