package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun DetailImageSelected(
    @DrawableRes image: Int,
    contentDescription: String
) = Image(
    painter = painterResource(id = image),
    contentDescription = contentDescription,
    modifier = Modifier
        .height(dimensionResource(id = R.dimen._45dp))
        .width(dimensionResource(id = R.dimen._83dp))
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._6dp)))
        .shadow(elevation = dimensionResource(id = R.dimen._4dp)),
    contentScale = ContentScale.Crop
)

@Composable
@Preview
fun DetailImageSelectedPreview() =
    DetailImageSelected(
        image = R.drawable.ic_huge,
        contentDescription = stringResource(id = R.string.empty)
    )