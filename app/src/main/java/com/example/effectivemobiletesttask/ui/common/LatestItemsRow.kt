package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.LatestItem

@Composable
fun LatestItemsRow(
    items: List<LatestItem>
) = LazyRow(modifier = Modifier.fillMaxWidth()) {
    itemsIndexed(items = items) { index, item ->
        com.example.effectivemobiletesttask.ui.common.LatestItem(
            image = item.image,
            contentDescriptionImage = item.contentDescriptionImage,
            height = item.height,
            width = item.width,
            radiusImage = item.radiusImage,
            icon = item.icon,
            contentDescriptionIcon = item.contentDescriptionIcon,
            text = item.text,
            color = item.color,
            radiusItem = item.radiusItem,
            fontSize = item.fontSize,
            name = item.name,
            price = item.price
        )
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._12dp)))
        }
    }
}