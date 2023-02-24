package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageInCircle(
    @DrawableRes icon: Int,
    contentDescription: String,
    size: Int,
    borderWidth: Int,
    @ColorRes color: Int
) = Image(
    painter = painterResource(id = icon),
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop,
    modifier = androidx.compose.ui.Modifier
        .size(size = size.dp)
        .clip(shape = CircleShape)
        .border(
            width = borderWidth.dp,
            color = colorResource(id = color),
            shape = CircleShape
        )
)