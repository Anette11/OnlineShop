package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun HugeImage(
    @DrawableRes image: Int,
    contentDescriptionImage: String,
    @DrawableRes icon: Int,
    contentDescriptionIcon: String,
    @DrawableRes iconTop: Int,
    contentDescriptionIconTop: String,
    @DrawableRes iconMiddle: Int,
    contentDescriptionIconMiddle: String,
    @DrawableRes iconBottom: Int,
    contentDescriptionIconBottom: String,
    onBackClick: () -> Unit,
    onLikeClick: () -> Unit,
    onShareClick: () -> Unit
) = Box(
    modifier = Modifier.fillMaxWidth()
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = contentDescriptionImage,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen._7dp),
                end = dimensionResource(id = R.dimen._40dp)
            )
            .clip(
                shape = RoundedCornerShape(
                    topEnd = dimensionResource(id = R.dimen._9dp),
                    bottomEnd = dimensionResource(id = R.dimen._9dp)
                )
            )
    )
    Row(
        modifier = Modifier
            .clickable { onBackClick() }
            .padding(
                start = dimensionResource(id = R.dimen._16dp),
                end = dimensionResource(id = R.dimen._16dp)
            )
            .align(Alignment.TopStart)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescriptionIcon
        )
    }
    Row(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(bottom = dimensionResource(id = R.dimen._28dp))
    ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._14dp)))
                .background(color = colorResource(id = R.color.gray_middle))
                .padding(dimensionResource(id = R.dimen._14dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconTop),
                contentDescription = contentDescriptionIconTop,
                tint = colorResource(id = R.color.purple),
                modifier = Modifier.clickable { onLikeClick() }
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._14dp)))
            Icon(
                painter = painterResource(id = iconMiddle),
                contentDescription = contentDescriptionIconMiddle,
                tint = colorResource(id = R.color.purple)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._14dp)))
            Icon(
                painter = painterResource(id = iconBottom),
                contentDescription = contentDescriptionIconBottom,
                tint = colorResource(id = R.color.purple),
                modifier = Modifier.clickable { onShareClick() }
            )
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._18dp)))
    }
}

@Composable
@Preview
fun HugeImagePreview() =
    HugeImage(
        image = R.drawable.ic_huge,
        contentDescriptionImage = stringResource(id = R.string.empty),
        icon = R.drawable.ic_arrow_back_small,
        contentDescriptionIcon = stringResource(id = R.string.empty),
        iconTop = R.drawable.ic_heart_large,
        contentDescriptionIconTop = stringResource(id = R.string.empty),
        iconMiddle = R.drawable.ic_dash,
        contentDescriptionIconMiddle = stringResource(id = R.string.empty),
        iconBottom = R.drawable.ic_share,
        contentDescriptionIconBottom = stringResource(id = R.string.empty),
        onBackClick = {},
        onLikeClick = {},
        onShareClick = {}
    )