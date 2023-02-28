package com.example.effectivemobiletesttask.ui.screens.items

import androidx.annotation.ColorRes
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

    data class IconTextIcon(
        @DrawableRes val iconLeft: Int,
        @DrawableRes val iconRight: Int,
        val contentDescriptionLeft: String,
        val contentDescriptionRight: String,
        val text: String
    ) : ScreenItem()

    data class IconTextText(
        @DrawableRes val icon: Int,
        val contentDescription: String,
        val textCenter: String,
        val textRight: String
    ) : ScreenItem()

    data class ItemAdditionalInfo(
        val text: String
    ) : ScreenItem()

    data class ItemBack(
        @DrawableRes val icon: Int,
        val contentDescription: String,
        val text: String
    ) : ScreenItem()

    data class ItemIcon(
        @DrawableRes val icon: Int,
        val contentDescription: String,
        val size: Int,
        val borderWidth: Int,
        @ColorRes val color: Int
    ) : ScreenItem()

    data class IconText(
        @DrawableRes val icon: Int,
        val contentDescription: String,
        val text: String
    ) : ScreenItem()

    data class TextSubtitle(
        val text: String
    ) : ScreenItem()

    data class LargeButtonIcon(
        val text: String,
        val onClick: () -> Unit,
        @DrawableRes val icon: Int,
        val contentDescription: String
    ) : ScreenItem()

    data class FilterRow(
        val items: List<FilterRowItem>
    ) : ScreenItem()
}