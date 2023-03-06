package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageItemCorners(
    image: Any?,
    contentDescription: String,
    height: Int,
    width: Int,
    radius: Int
) = GlideImage(
    modifier = Modifier
        .height(height = height.dp)
        .width(width = width.dp)
        .clip(shape = RoundedCornerShape(size = radius.dp)),
    model = image,
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop
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