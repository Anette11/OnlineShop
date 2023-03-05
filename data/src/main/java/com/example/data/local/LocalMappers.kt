package com.example.data.local

import com.example.data.local.user.UserDbo
import com.example.domain.data.local.User

fun UserDbo.toUser() =
    User(
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        imageUri = this.imageUri,
        isLoggedIn = this.isLoggedIn,
        email = this.email
    )

fun User.toUserDbo() =
    UserDbo(
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        imageUri = this.imageUri,
        isLoggedIn = this.isLoggedIn,
        email = this.email
    )