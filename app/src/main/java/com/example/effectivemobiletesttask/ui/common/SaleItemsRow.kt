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
import com.example.effectivemobiletesttask.ui.screens.items.SaleItem

@Composable
fun SaleItemsRow(
    items: List<SaleItem>
) = LazyRow(modifier = Modifier.fillMaxWidth()) {
    itemsIndexed(items = items) { index, item ->
        com.example.effectivemobiletesttask.ui.common.SaleItem(
            image = item.image,
            contentDescriptionImage = item.contentDescriptionImage,
            height = item.height,
            width = item.width,
            radiusImage = item.radiusImage,
            iconSmall = item.iconSmall,
            contentDescriptionIconSmall = item.contentDescriptionIconSmall,
            iconLarge = item.iconLarge,
            contentDescriptionIconLarge = item.contentDescriptionIconLarge,
            text = item.text,
            color = item.color,
            radiusItem = item.radiusItem,
            fontSize = item.fontSize,
            name = item.name,
            price = item.price,
            imageTop = item.imageTop,
            contentDescriptionIconTop = item.contentDescriptionIconTop,
            discountText = item.discountText
        )
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._9dp)))
        }
    }
}