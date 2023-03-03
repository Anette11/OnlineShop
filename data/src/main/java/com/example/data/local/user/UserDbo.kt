package com.example.data.local.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDbo(
    val firstName: String,
    val lastName: String,
    val password: String,

    @PrimaryKey(autoGenerate = false)
    val email: String
)