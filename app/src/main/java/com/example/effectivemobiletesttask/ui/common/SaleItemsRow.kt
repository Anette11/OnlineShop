package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            discountText = item.discountText,
            onItemClick = item.onItemClick
        )
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._9dp)))
        }
    }
}

@Composable
@Preview
fun SaleItemsRow() =
    SaleItemsRow(
        items = buildList {
            for (i in 0..4) {
                add(
                    SaleItem(
                        image = R.drawable.ic_snickers,
                        contentDescriptionImage = stringResource(id = R.string.empty),
                        height = integerResource(id = R.integer._221),
                        width = integerResource(id = R.integer._174),
                        radiusImage = integerResource(id = R.integer._11),
                        text = stringResource(id = R.string.kids),
                        color = R.color.gray_half_transparent,
                        radiusItem = integerResource(id = R.integer._8),
                        fontSize = integerResource(id = R.integer._9),
                        name = stringResource(id = R.string.new_balance_sneakers),
                        price = stringResource(id = R.string.price_test),
                        iconSmall = R.drawable.ic_like_small,
                        contentDescriptionIconSmall = stringResource(id = R.string.empty),
                        iconLarge = R.drawable.ic_add_large,
                        contentDescriptionIconLarge = stringResource(id = R.string.empty),
                        imageTop = R.drawable.ic_person,
                        contentDescriptionIconTop = stringResource(id = R.string.empty),
                        discountText = stringResource(id = R.string.discount_text),
                        onItemClick = {}
                    )
                )
            }
        }
    )