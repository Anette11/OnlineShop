package com.example.effectivemobiletesttask.util

import android.util.Patterns

class EmailValidator {

    fun isEmailValid(email: CharSequence): Boolean =
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}