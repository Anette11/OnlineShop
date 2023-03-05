package com.example.data.local.user

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDbo(

    @PrimaryKey(autoGenerate = false)
    val firstName: String,

    val lastName: String,
    val password: String,
    val imageUri: Uri?,
    val isLoggedIn: Boolean,
    val email: String
)