package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletesttask.R

@Composable
fun ImageItemCorners(
    @DrawableRes image: Int,
    contentDescription: String,
    height: Int,
    width: Int,
    radius: Int
) = Image(
    modifier = Modifier
        .height(height = height.dp)
        .width(width = width.dp)
        .clip(shape = RoundedCornerShape(size = radius.dp)),
    painter = painterResource(id = image),
    contentDescription = contentDescription
)

@Composable
@Preview
fun ImageItemCornersPreview() =
    ImageItemCorners(
        image = R.drawable.ic_rectangle,
        contentDescription = stringResource(id = R.string.empty),
        height = integerResource(id = R.integer._149),
        width = integerResource(id = R.integer._114),
        radius = integerResource(id = R.integer._9)
    )