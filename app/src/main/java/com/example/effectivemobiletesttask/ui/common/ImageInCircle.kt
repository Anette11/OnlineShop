package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageInCircle(
    icon: Any?,
    contentDescription: String,
    size: Int,
    borderWidth: Int,
    @ColorRes color: Int
) = GlideImage(
    modifier = Modifier
        .size(size = size.dp)
        .clip(shape = CircleShape)
        .border(
            width = borderWidth.dp,
            color = colorResource(id = color),
            shape = CircleShape
        ),
    model = icon,
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop
)

@Composable
@Preview
fun ImageInCirclePreview() =
    ImageInCircle(
        icon = R.drawable.image_default,
        contentDescription = stringResource(R.string.empty),
        size = integerResource(id = R.integer._31),
        borderWidth = integerResource(id = R.integer._2),
        color = R.color.gray_lighter
    )