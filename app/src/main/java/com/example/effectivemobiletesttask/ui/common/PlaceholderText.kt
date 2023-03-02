package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun PlaceholderText(
    placeholder: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    Text(
        text = placeholder,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontSize = dimensionResource(id = R.dimen._11sp).value.sp,
        color = colorResource(id = R.color.gray_dark),
        style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    )
}

@Composable
@Preview
fun PlaceholderTextPreview() =
    PlaceholderText(
        placeholder = stringResource(id = R.string.first_name)
    )