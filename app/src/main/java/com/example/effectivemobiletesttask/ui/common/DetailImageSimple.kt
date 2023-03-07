package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailImageSimple(
    image: Any?,
    contentDescription: String,
    index: Int,
    onSelect: (Int) -> Unit
) = GlideImage(
    model = image,
    contentDescription = contentDescription,
    modifier = Modifier
        .height(dimensionResource(id = R.dimen._38dp))
        .width(dimensionResource(id = R.dimen._66dp))
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._6dp)))
        .clickable { onSelect(index) },
    contentScale = ContentScale.Crop
)

@Composable
@Preview
fun DetailImageSimplePreview() =
    DetailImageSimple(
        image = R.drawable.ic_huge,
        contentDescription = stringResource(id = R.string.empty),
        index = 0,
        onSelect = {}
    )