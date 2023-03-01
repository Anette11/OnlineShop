package com.example.effectivemobiletesttask.util

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

interface ResourcesProvider {

    fun getString(@StringRes resId: Int): String

    fun getInteger(@IntegerRes resId: Int): Int
}