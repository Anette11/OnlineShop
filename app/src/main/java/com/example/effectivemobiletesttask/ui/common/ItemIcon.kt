package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun ItemIcon(
    @DrawableRes icon: Int,
    contentDescription: String,
    size: Int,
    borderWidth: Int,
    @ColorRes color: Int
) = Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
) {
    ImageInCircle(
        icon = icon,
        contentDescription = contentDescription,
        size = size,
        borderWidth = borderWidth,
        color = color
    )
}

@Composable
@Preview
fun ItemIconPreview() =
    ItemIcon(
        icon = R.drawable.ic_launcher_foreground,
        contentDescription = stringResource(id = R.string.empty),
        size = 61,
        borderWidth = 2,
        color = R.color.gray_lighter
    )