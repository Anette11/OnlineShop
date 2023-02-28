package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.DrawableRes

data class FilterRowItem(
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val hint: String
)
