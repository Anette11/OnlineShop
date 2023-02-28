package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletesttask.R

@Composable
fun IconInCircle(
    @DrawableRes icon: Int,
    contentDescription: String,
    height: Int,
    width: Int
) = Box(
    modifier = Modifier
        .height(height = height.dp)
        .width(width = width.dp)
        .clip(shape = CircleShape)
        .background(color = colorResource(id = R.color.gray_lighter))
        .padding(dimensionResource(id = R.dimen._8dp)),
    contentAlignment = Alignment.Center
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription
    )
}

@Composable
@Preview
fun IconInCirclePreview() =
    IconInCircle(
        icon = R.drawable.ic_credit_card,
        contentDescription = stringResource(id = R.string.empty),
        height = integerResource(id = R.integer._40),
        width = integerResource(id = R.integer._40)
    )