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

@Composable
@Preview
fun LatestItemsRowPreview() =
    LatestItemsRow(
        items = buildList {
            for (i in 0..4) {
                add(
                    LatestItem(
                        image = R.drawable.ic_rectangle,
                        contentDescriptionImage = stringResource(id = R.string.empty),
                        height = integerResource(id = R.integer._149),
                        width = integerResource(id = R.integer._114),
                        radiusImage = integerResource(id = R.integer._9),
                        icon = R.drawable.ic_add_small,
                        contentDescriptionIcon = stringResource(id = R.string.empty),
                        text = stringResource(id = R.string.phones),
                        color = R.color.gray_half_transparent,
                        radiusItem = integerResource(id = R.integer._5),
                        fontSize = integerResource(id = R.integer._6),
                        name = stringResource(id = R.string.play_station_5_console),
                        price = stringResource(id = R.string.price_test)
                    )
                )
            }
        }
    )