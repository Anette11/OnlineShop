package com.example.data.di

import com.example.data.repositories.TradeRepositoryImpl
import com.example.data.repositories.UserRepositoryImpl
import com.example.data.repositories.WordsRepositoryImpl
import com.example.domain.repository.TradeRepository
import com.example.domain.repository.UserRepository
import com.example.domain.repository.WordsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindTradeRepository(
        tradeRepositoryImpl: TradeRepositoryImpl
    ): TradeRepository

    @Binds
    @Singleton
    abstract fun bindWordsRepository(
        wordsRepositoryImpl: WordsRepositoryImpl
    ): WordsRepository
}