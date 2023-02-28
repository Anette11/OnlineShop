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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.effectivemobiletesttask.R

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

@Composable
@Preview
fun ImageInCirclePreview() =
    ImageInCircle(
        icon = R.drawable.ic_launcher_foreground,
        contentDescription = stringResource(R.string.empty),
        size = 31,
        borderWidth = 2,
        color = R.color.gray_lighter
    )