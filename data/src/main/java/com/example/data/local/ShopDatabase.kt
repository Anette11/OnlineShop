package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.user.UserDbo

@Database(
    entities = [UserDbo::class],
    version = 1
)
abstract class ShopDatabase : RoomDatabase() {

    companion object {
        const val shorDatabaseName = "shop_database"
    }

    abstract val userDao: UserDao
}