package com.example.effectivemobiletesttask.di

import com.example.effectivemobiletesttask.util.EmailValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilModule {

    @Provides
    @Singleton
    fun provideEmailValidator(): EmailValidator = EmailValidator()
}