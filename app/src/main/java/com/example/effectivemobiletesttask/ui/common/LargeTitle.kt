package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun LargeTitle(
    title: String
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(id = R.dimen._8dp)),
    horizontalArrangement = Arrangement.Center
) {
    Text(
        text = title,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontSize = dimensionResource(id = R.dimen._26sp).value.sp,
        color = colorResource(id = R.color.black)
    )
}

@Composable
@Preview
fun LargeTitlePreview() =
    LargeTitle(title = stringResource(id = R.string.sign_in))