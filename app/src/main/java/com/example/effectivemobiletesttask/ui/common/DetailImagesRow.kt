package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.DetailImageItem

@Composable
fun DetailImagesRow(
    items: List<DetailImageItem>
) = LazyRow(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
) {
    itemsIndexed(items = items) { index, item ->
        if (item.isSelected) {
            DetailImageSelected(
                image = item.image,
                contentDescription = item.contentDescription
            )
        } else {
            DetailImageSimple(
                image = item.image,
                contentDescription = item.contentDescription
            )
        }
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._4dp)))
        }
    }
}

@Composable
@Preview
fun DetailImagesRowPreview() =
    DetailImagesRow(
        items = listOf(
            DetailImageItem(
                image = R.drawable.ic_huge,
                contentDescription = stringResource(id = R.string.empty),
                isSelected = false
            ),
            DetailImageItem(
                image = R.drawable.ic_huge,
                contentDescription = stringResource(id = R.string.empty),
                isSelected = true
            ),
            DetailImageItem(
                image = R.drawable.ic_huge,
                contentDescription = stringResource(id = R.string.empty),
                isSelected = false
            )
        )
    )