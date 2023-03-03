package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.ShopDatabase
import com.example.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideShopDatabase(
        @ApplicationContext context: Context
    ): ShopDatabase = Room.databaseBuilder(
        context = context,
        klass = ShopDatabase::class.java,
        name = ShopDatabase.shorDatabaseName
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(
        shopDatabase: ShopDatabase
    ): UserDao = shopDatabase.userDao
}