package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class LatestItem(
    @DrawableRes val image: Int,
    val contentDescriptionImage: String,
    val height: Int,
    val width: Int,
    val radiusImage: Int,
    @DrawableRes val icon: Int,
    val contentDescriptionIcon: String,
    val text: String,
    @ColorRes val color: Int,
    val radiusItem: Int,
    val fontSize: Int,
    val name: String,
    val price: String
)