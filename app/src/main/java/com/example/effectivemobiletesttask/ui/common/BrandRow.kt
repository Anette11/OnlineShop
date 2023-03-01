package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.BrandItem

@Composable
fun BrandRow(
    items: List<BrandItem>
) = LazyRow(modifier = Modifier.fillMaxWidth()) {
    itemsIndexed(items = items) { index, item ->
        com.example.effectivemobiletesttask.ui.common.BrandItem(
            image = item.image,
            text = item.text
        )
        if (index != items.size - 1) {
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._12dp)))
        }
    }
}

@Composable
@Preview
fun BrandRowPreview() =
    BrandRow(
        items = buildList {
            for (i in 0..3) {
                add(
                    BrandItem(
                        image = R.drawable.ic_huge,
                        text = stringResource(id = R.string.brand)
                    )
                )
            }
        }
    )