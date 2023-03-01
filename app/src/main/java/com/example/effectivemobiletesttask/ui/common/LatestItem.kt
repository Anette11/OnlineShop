package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun LatestItem(
    @DrawableRes image: Int,
    contentDescriptionImage: String,
    height: Int,
    width: Int,
    radiusImage: Int,
    @DrawableRes icon: Int,
    contentDescriptionIcon: String,
    text: String,
    @ColorRes color: Int,
    radiusItem: Int,
    fontSize: Int,
    name: String,
    price: String
) = Box(
    modifier = Modifier.width(width = width.dp),
    contentAlignment = Alignment.BottomCenter
) {
    ImageItemCorners(
        image = image,
        contentDescription = contentDescriptionImage,
        height = height,
        width = width,
        radius = radiusImage
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen._7dp),
                end = dimensionResource(id = R.dimen._5dp),
                bottom = dimensionResource(id = R.dimen._5dp),
            ),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = dimensionResource(id = R.dimen._2dp))
        ) {
            GroupItem(
                text = text,
                color = color,
                radius = radiusItem,
                fontSize = fontSize
            )
            Text(
                text = name.plus("\n"),
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = colorResource(id = R.color.white),
                fontSize = dimensionResource(id = R.dimen._9sp).value.sp,
                maxLines = integerResource(id = R.integer._2)
            )
            Text(
                text = price,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = colorResource(id = R.color.white),
                fontSize = dimensionResource(id = R.dimen._9sp).value.sp
            )
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._6dp)))
        Image(
            painter = painterResource(id = icon),
            contentDescription = contentDescriptionIcon
        )
    }
}

@Composable
@Preview
fun LatestItemPreview() =
    LatestItem(
        image = R.drawable.ic_rectangle,
        contentDescriptionImage = stringResource(id = R.string.empty),
        height = integerResource(id = R.integer._149),
        width = integerResource(id = R.integer._114),
        radiusImage = integerResource(id = R.integer._9),
        icon = R.drawable.ic_add_small,
        contentDescriptionIcon = stringResource(id = R.string.empty),
        text = stringResource(id = R.string.phones),
        color = R.color.gray_half_transparent,
        radiusItem = integerResource(id = R.integer._5),
        fontSize = integerResource(id = R.integer._6),
        name = stringResource(id = R.string.play_station_5_console),
        price = stringResource(id = R.string.price_test)
    )