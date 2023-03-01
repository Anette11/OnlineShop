package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class SaleItem(
    @DrawableRes val image: Int,
    val contentDescriptionImage: String,
    val height: Int,
    val width: Int,
    val radiusImage: Int,
    @DrawableRes val iconSmall: Int,
    val contentDescriptionIconSmall: String,
    @DrawableRes val iconLarge: Int,
    val contentDescriptionIconLarge: String,
    val text: String,
    @ColorRes val color: Int,
    val radiusItem: Int,
    val fontSize: Int,
    val name: String,
    val price: String,
    @DrawableRes val imageTop: Int,
    val contentDescriptionIconTop: String,
    val discountText: String,
    val onItemClick: () -> Unit
)