package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun Reviews(
    rating: String,
    reviews: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_star),
        contentDescription = stringResource(id = R.string.empty),
        tint = colorResource(id = R.color.yellow)
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._3dp)))
    Text(
        text = rating,
        fontFamily = FontFamily(Font((R.font.poppins_semi_bold))),
        color = colorResource(id = R.color.black),
        fontSize = dimensionResource(id = R.dimen._9sp).value.sp
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._3dp)))
    Text(
        text = reviews,
        fontFamily = FontFamily(Font((R.font.poppins_regular))),
        color = colorResource(id = R.color.gray_darker),
        fontSize = dimensionResource(id = R.dimen._9sp).value.sp
    )
}

@Composable
@Preview
fun ReviewsPreview() =
    Reviews(
        rating = stringResource(id = R.string.rating),
        reviews = stringResource(id = R.string.reviews)
    )