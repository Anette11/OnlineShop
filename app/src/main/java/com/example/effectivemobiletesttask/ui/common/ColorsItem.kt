package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ColorItem

@Composable
fun ColorsItem(
    text: String,
    items: List<ColorItem>
) = Column(modifier = Modifier.fillMaxWidth()) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = dimensionResource(id = R.dimen._10sp).value.sp,
        color = colorResource(id = R.color.gray_darkest)
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._11dp)))
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(items = items) { index, item ->
            com.example.effectivemobiletesttask.ui.common.ColorItem(color = item.color)
            if (index != items.size - 1) {
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._14dp)))
            }
        }
    }
}

@Composable
@Preview
fun ColorsItemPreview() =
    ColorsItem(
        text = stringResource(id = R.string.color),
        items = listOf(
            ColorItem(color = "#ffffff"),
            ColorItem(color = "#b5b5b5"),
            ColorItem(color = "#000000")
        )
    )