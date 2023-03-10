package com.example.effectivemobiletesttask.di

import com.example.effectivemobiletesttask.util.ClickActionTransmitter
import com.example.effectivemobiletesttask.util.EmailValidator
import com.example.effectivemobiletesttask.util.MapKeysCreator
import com.example.effectivemobiletesttask.util.NavigationActionTransmitter
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
    fun provideEmailValidator(
    ): EmailValidator = EmailValidator()

    @Provides
    fun provideMapKeysCreator(
    ): MapKeysCreator = MapKeysCreator()

    @Provides
    @Singleton
    fun provideClickActionTransmitter(
    ): ClickActionTransmitter = ClickActionTransmitter()

    @Provides
    @Singleton
    fun provideNavigationActionTransmitter(
    ): NavigationActionTransmitter = NavigationActionTransmitter()
}