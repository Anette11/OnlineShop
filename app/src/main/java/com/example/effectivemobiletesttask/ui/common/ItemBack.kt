package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ItemBack(
    @DrawableRes icon: Int,
    contentDescription: String,
    text: String
) = Box(modifier = Modifier.fillMaxWidth()) {
    Icon(
        modifier = Modifier.align(Alignment.CenterStart),
        painter = painterResource(id = icon),
        contentDescription = contentDescription
    )
    Text(
        modifier = Modifier.align(Alignment.Center),
        text = text,
        color = colorResource(id = R.color.black_dark),
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontSize = dimensionResource(id = R.dimen._15sp).value.sp
    )
}

@Composable
@Preview
fun ItemBackPreview() =
    ItemBack(
        icon = R.drawable.arrow_left,
        contentDescription = stringResource(id = R.string.empty),
        text = stringResource(id = R.string.profile)
    )