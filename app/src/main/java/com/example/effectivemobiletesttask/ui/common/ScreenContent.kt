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
            is ScreenItem.IconTextItem -> IconTextItem(
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
            is ScreenItem.ItemText -> ItemText(
                icon = item.icon,
                contentDescription = item.contentDescription,
                text = item.text
            )
        }
    }
}