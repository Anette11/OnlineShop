package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.user.UserDbo

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserDbo)

    @Query("SELECT * FROM user WHERE firstName = :firstName LIMIT 1")
    fun getUserByFirstName(firstName: String): UserDbo?

    @Query("SELECT * FROM user WHERE isLoggedIn = :isLoggedIn LIMIT 1")
    fun getUserByIsLoggedIn(isLoggedIn: Boolean): UserDbo?
}