package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.DrawableRes

sealed class ScreenItem {

    data class LargeTitle(
        val title: String
    ) : ScreenItem()

    data class SimpleRow(
        val placeholder: String,
        val value: String,
        val onValueChange: (String) -> Unit,
        val showIcon: Boolean
    ) : ScreenItem()

    data class LargeButton(
        val text: String,
        val onClick: () -> Unit
    ) : ScreenItem()

    data class InfoRow(
        val textInfo: String,
        val textClickable: String,
        val onClick: () -> Unit
    ) : ScreenItem()

    data class IconTextRow(
        @DrawableRes val icon: Int,
        val contentDescription: String,
        val text: String,
        val onClick: () -> Unit
    ) : ScreenItem()

    data class SpacerRow(
        val height: Int
    ) : ScreenItem()
}