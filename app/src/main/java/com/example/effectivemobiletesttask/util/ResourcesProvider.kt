package com.example.effectivemobiletesttask.util

import androidx.annotation.StringRes

interface ResourcesProvider {

    fun getString(@StringRes resId: Int): String
}