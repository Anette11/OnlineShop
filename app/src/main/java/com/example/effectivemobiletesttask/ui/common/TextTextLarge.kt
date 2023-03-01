package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun TextTextLarge(
    textStart: String,
    textEnd: String
) = Row(modifier = Modifier.fillMaxWidth()) {
    Text(
        modifier = Modifier.weight(1f),
        text = textStart,
        color = colorResource(id = R.color.black),
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = dimensionResource(id = R.dimen._17sp).value.sp
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Text(
        text = textEnd,
        color = colorResource(id = R.color.black),
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = dimensionResource(id = R.dimen._13sp).value.sp
    )
}

@Composable
@Preview
fun TextTextLargePreview() =
    TextTextLarge(
        textStart = stringResource(id = R.string.new_balance_sneakers),
        textEnd = stringResource(id = R.string.balance)
    )