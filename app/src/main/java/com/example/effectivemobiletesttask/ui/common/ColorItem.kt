package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColorInt
import com.example.effectivemobiletesttask.R

@Composable
fun ColorItem(
    color: String
) = Row(
    modifier = Modifier
        .width(dimensionResource(id = R.dimen._34dp))
        .height(dimensionResource(id = R.dimen._26dp))
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._9dp)))
        .background(Color(color.toColorInt()))
        .border(
            width = dimensionResource(id = R.dimen._2dp),
            color = if (color.equals(
                    stringResource(id = R.string.color_white),
                    true
                )
            ) colorResource(id = R.color.gray_soft)
            else Color.Transparent,
            shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._9dp))
        )
) {}

@Composable
@Preview
fun ColorItemPreview() =
    ColorItem(color = stringResource(id = R.string.color_test))
