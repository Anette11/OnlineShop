package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun SaleItem(
    image: Any?,
    contentDescriptionImage: String,
    height: Int,
    width: Int,
    radiusImage: Int,
    @DrawableRes iconSmall: Int,
    contentDescriptionIconSmall: String,
    @DrawableRes iconLarge: Int,
    contentDescriptionIconLarge: String,
    text: String,
    @ColorRes color: Int,
    radiusItem: Int,
    fontSize: Int,
    name: String,
    price: String,
    @DrawableRes imageTop: Int,
    contentDescriptionIconTop: String,
    discountText: String,
    onItemClick: () -> Unit
) = Box(
    modifier = Modifier
        .width(width = width.dp)
        .clickable { onItemClick() },
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
                start = dimensionResource(id = R.dimen._9dp),
                end = dimensionResource(id = R.dimen._4dp),
                bottom = dimensionResource(id = R.dimen._7dp)
            ),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = dimensionResource(id = R.dimen._10dp))
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
                fontSize = dimensionResource(id = R.dimen._13sp).value.sp,
                maxLines = integerResource(id = R.integer._2)
            )
            Text(
                text = price,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = colorResource(id = R.color.white),
                fontSize = dimensionResource(id = R.dimen._10sp).value.sp
            )
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._6dp)))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconSmall),
                contentDescription = contentDescriptionIconSmall
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._5dp)))
            Image(
                painter = painterResource(id = iconLarge),
                contentDescription = contentDescriptionIconLarge
            )
        }
    }
    Image(
        painter = painterResource(id = imageTop),
        contentDescription = contentDescriptionIconTop,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen._8dp))
            .size(dimensionResource(id = R.dimen._25dp))
            .align(Alignment.TopStart)
    )
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen._8dp))
            .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._9dp)))
            .background(color = colorResource(id = R.color.red))
            .align(Alignment.TopEnd)
    ) {
        Text(
            text = discountText,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = dimensionResource(id = R.dimen._10sp).value.sp,
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen._4dp),
                vertical = dimensionResource(id = R.dimen._2dp)
            )
        )
    }
}

@Composable
@Preview
fun SaleItemPreview() =
    SaleItem(
        image = R.drawable.ic_snickers,
        contentDescriptionImage = stringResource(id = R.string.empty),
        height = integerResource(id = R.integer._221),
        width = integerResource(id = R.integer._174),
        radiusImage = integerResource(id = R.integer._11),
        text = stringResource(id = R.string.kids),
        color = R.color.gray_half_transparent,
        radiusItem = integerResource(id = R.integer._8),
        fontSize = integerResource(id = R.integer._9),
        name = stringResource(id = R.string.new_balance_sneakers),
        price = stringResource(id = R.string.price_test),
        iconSmall = R.drawable.ic_like_small,
        contentDescriptionIconSmall = stringResource(id = R.string.empty),
        iconLarge = R.drawable.ic_add_large,
        contentDescriptionIconLarge = stringResource(id = R.string.empty),
        imageTop = R.drawable.ic_person,
        contentDescriptionIconTop = stringResource(id = R.string.empty),
        discountText = stringResource(id = R.string.discount_text),
        onItemClick = {}
    )