package com.example.data.mappers

import com.example.data.local.user.UserDbo
import com.example.domain.data.User

fun UserDbo.toUser() =
    User(
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        imageUri = this.imageUri,
        email = this.email
    )

fun User.toUserDbo() =
    UserDbo(
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        imageUri = this.imageUri,
        email = this.email
    )