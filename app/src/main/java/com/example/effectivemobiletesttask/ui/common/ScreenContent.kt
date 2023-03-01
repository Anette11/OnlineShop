package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem

@Composable
fun ScreenContent(
    items: List<ScreenItem>,
    horizontalPadding: Dp
) = LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = horizontalPadding)
) {
    items(items = items) { item ->
        when (item) {
            is ScreenItem.IconTextRow -> IconTextRow(
                icon = item.icon,
                contentDescription = item.contentDescription,
                text = item.text,
                onClick = item.onClick
            )
            is ScreenItem.InfoRow -> InfoRow(
                textInfo = item.textInfo,
                textClickable = item.textClickable,
                onClick = item.onClick
            )
            is ScreenItem.LargeButton -> LargeButton(
                text = item.text,
                onClick = item.onClick
            )
            is ScreenItem.LargeTitle -> LargeTitle(
                title = item.title
            )
            is ScreenItem.SimpleRow -> SimpleRow(
                placeholder = item.placeholder,
                value = item.value,
                onValueChange = item.onValueChange,
                showIcon = item.showIcon
            )
            is ScreenItem.SpacerRow -> SpacerRow(
                height = item.height
            )
            is ScreenItem.IconTextIcon -> IconTextIcon(
                iconLeft = item.iconLeft,
                iconRight = item.iconRight,
                contentDescriptionLeft = item.contentDescriptionLeft,
                contentDescriptionRight = item.contentDescriptionRight,
                text = item.text
            )
            is ScreenItem.IconTextText -> IconTextText(
                icon = item.icon,
                contentDescription = item.contentDescription,
                textCenter = item.textCenter,
                textRight = item.textRight
            )
            is ScreenItem.ItemAdditionalInfo -> ItemAdditionalInfo(
                text = item.text
            )
            is ScreenItem.ItemBack -> ItemBack(
                icon = item.icon,
                contentDescription = item.contentDescription,
                text = item.text
            )
            is ScreenItem.ItemIcon -> ItemIcon(
                icon = item.icon,
                contentDescription = item.contentDescription,
                size = item.size,
                borderWidth = item.borderWidth,
                color = item.color
            )
            is ScreenItem.IconText -> IconText(
                icon = item.icon,
                contentDescription = item.contentDescription,
                text = item.text
            )
            is ScreenItem.TextSubtitle -> TextSubtitle(
                text = item.text
            )
            is ScreenItem.LargeButtonIcon -> LargeButtonIcon(
                text = item.text,
                onClick = item.onClick,
                icon = item.icon,
                contentDescription = item.contentDescription
            )
            is ScreenItem.FilterRow -> FilterRow(
                items = item.items
            )
            is ScreenItem.IconTextIconLarge -> IconTextIconLarge(
                iconLeft = item.iconLeft,
                contentDescription = item.contentDescription,
                textMain = item.textMain,
                textAdditional = item.textAdditional,
                iconRight = item.iconRight,
                contentDescriptionRight = item.contentDescriptionRight,
                size = item.size,
                borderWidth = item.borderWidth,
                color = item.color
            )
            is ScreenItem.LocationItem -> LocationItem(
                text = item.text,
                icon = item.icon,
                contentDescription = item.contentDescription
            )
            is ScreenItem.SearchRow -> SearchRow(
                placeholder = item.placeholder,
                value = item.value,
                onValueChange = item.onValueChange
            )
            is ScreenItem.TextSpaceText -> TextSpaceText(
                textStart = item.textStart,
                textEnd = item.textEnd
            )
            is ScreenItem.LatestItemsRow -> LatestItemsRow(
                items = item.items
            )
            is ScreenItem.SaleItemsRow -> SaleItemsRow(
                items = item.items
            )
        }
    }
}