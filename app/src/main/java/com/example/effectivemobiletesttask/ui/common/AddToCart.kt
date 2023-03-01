package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun AddToCart(
    amount: String
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .clip(
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen._25dp),
                topEnd = dimensionResource(id = R.dimen._25dp)
            )
        )
        .background(color = colorResource(id = R.color.black_dark))
        .padding(
            top = dimensionResource(id = R.dimen._14dp),
            bottom = dimensionResource(id = R.dimen._22dp),
            start = dimensionResource(id = R.dimen._22dp),
            end = dimensionResource(id = R.dimen._22dp)
        ),
    verticalAlignment = Alignment.CenterVertically
) {
    Column(modifier = Modifier.weight(1f)) {
        Text(
            text = stringResource(id = R.string.quantity),
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = dimensionResource(id = R.dimen._9sp).value.sp,
            color = colorResource(id = R.color.gray_darker)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._10dp)))
        Row(verticalAlignment = Alignment.CenterVertically) {
            SmallButton(
                text = stringResource(id = R.string.minus),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._20dp)))
            SmallButton(
                text = stringResource(id = R.string.plus),
                modifier = Modifier.weight(1f)
            )
        }
    }
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Row(
        modifier = Modifier
            .weight(1f)
            .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
            .background(color = colorResource(id = R.color.blue))
            .padding(
                horizontal = dimensionResource(id = R.dimen._16dp),
                vertical = dimensionResource(id = R.dimen._18dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            text = amount,
            color = colorResource(id = R.color.blue_lighter),
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            text = stringResource(id = R.string.add_to_cart),
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun AddToCartPreview() =
    AddToCart(amount = stringResource(id = R.string.balance_value))