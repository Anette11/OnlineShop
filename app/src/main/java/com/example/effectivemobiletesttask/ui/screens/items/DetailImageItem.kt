package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.DrawableRes

data class DetailImageItem(
    @DrawableRes val image: Int,
    val contentDescription: String,
    val isSelected: Boolean
)