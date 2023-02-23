package com.example.effectivemobiletesttask.di

import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.ResourcesProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ResourcesModule {

    @Binds
    @Singleton
    abstract fun bindResourcesProvider(
        resourcesProviderImpl: ResourcesProviderImpl
    ): ResourcesProvider
}