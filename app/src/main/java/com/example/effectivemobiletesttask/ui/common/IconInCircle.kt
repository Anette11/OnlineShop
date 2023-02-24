package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.effectivemobiletesttask.R

@Composable
fun IconInCircle(
    @DrawableRes icon: Int,
    contentDescription: String
) = Box(
    modifier = Modifier
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