package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun LargeButton(
    text: String,
    onClick: () -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
        .clickable { onClick() }
        .background(color = colorResource(id = R.color.blue))
        .padding(dimensionResource(id = R.dimen._14dp)),
    horizontalArrangement = Arrangement.Center
) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        color = colorResource(id = R.color.gray_light),
        fontSize = dimensionResource(id = R.dimen._14sp).value.sp
    )
}

@Composable
@Preview
fun LargeButtonPreview() =
    LargeButton(
        text = stringResource(id = R.string.sign_in),
        onClick = {}
    )