package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun AddToCart(
    quantity: Int,
    amount: String,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit,
    onAddToCardCardClick: () -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Transparent)
        .height(dimensionResource(R.dimen._88dp))
        .background(color = colorResource(id = R.color.black_dark))
        .padding(dimensionResource(id = R.dimen._22dp)),
    verticalAlignment = Alignment.CenterVertically
) {
    Column(modifier = Modifier.weight(1f)) {
        Text(
            text = "${stringResource(id = R.string.quantity)} $quantity",
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = dimensionResource(id = R.dimen._9sp).value.sp,
            color = colorResource(id = R.color.gray_darker)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._10dp)))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen._38dp))
                    .height(dimensionResource(id = R.dimen._22dp))
                    .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._8dp)))
                    .background(color = colorResource(id = R.color.blue))
                    .clickable { onDecreaseClick() },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_horizontal_bar),
                    contentDescription = stringResource(id = R.string.empty),
                    tint = colorResource(id = R.color.white)
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._20dp)))
            Row(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen._38dp))
                    .height(dimensionResource(id = R.dimen._22dp))
                    .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._8dp)))
                    .background(color = colorResource(id = R.color.blue))
                    .clickable { onIncreaseClick() },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_horizontal_bar),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = colorResource(id = R.color.white)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vertical_bar),
                        contentDescription = stringResource(id = R.string.empty),
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Row(
        modifier = Modifier
            .weight(1f)
            .height(dimensionResource(id = R.dimen._44dp))
            .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
            .background(color = colorResource(id = R.color.blue))
            .clickable { onAddToCardCardClick() }
            .padding(dimensionResource(id = R.dimen._8dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = amount,
            color = colorResource(id = R.color.blue_lighter),
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
        Text(
            text = stringResource(id = R.string.add_to_cart),
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
            textAlign = TextAlign.Center,
            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
        )
    }
}

@Composable
@Preview
fun AddToCartPreview() =
    AddToCart(
        quantity = integerResource(id = R.integer._1),
        amount = stringResource(id = R.string.balance_value),
        onIncreaseClick = {},
        onDecreaseClick = {},
        onAddToCardCardClick = {}
    )