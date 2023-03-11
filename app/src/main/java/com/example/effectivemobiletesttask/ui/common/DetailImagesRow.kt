package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.DetailImageItem

@Composable
fun DetailImagesRow(
    items: List<DetailImageItem>,
    horizontalPadding: Int,
    onSelect: (Int) -> Unit,
    currentPage: Int
) = LazyRow(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = horizontalPadding.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
) {
    itemsIndexed(items = items) { index, item ->
        if (index == currentPage) {
            DetailImageSelected(
                image = item.image,
                contentDescription = item.contentDescription
            )
        } else {
            DetailImageSimple(
                image = item.image,
                contentDescription = item.contentDescription,
                index = index,
                onSelect = onSelect
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
                contentDescription = stringResource(id = R.string.empty)
            ),
            DetailImageItem(
                image = R.drawable.ic_huge,
                contentDescription = stringResource(id = R.string.empty)
            ),
            DetailImageItem(
                image = R.drawable.ic_huge,
                contentDescription = stringResource(id = R.string.empty)
            )
        ),
        horizontalPadding = integerResource(id = R.integer._24),
        onSelect = {},
        currentPage = integerResource(id = R.integer._1)
    )