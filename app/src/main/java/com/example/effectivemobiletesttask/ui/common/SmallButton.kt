package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun SmallButton(
    text: String,
    modifier: Modifier
) = Row(
    modifier = modifier
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._8dp)))
        .background(color = colorResource(id = R.color.blue))
        .padding(
            horizontal = dimensionResource(id = R.dimen._15dp),
            vertical = dimensionResource(id = R.dimen._11dp)
        )
) {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = text,
        color = colorResource(id = R.color.white),
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
fun SmallButtonPreview() =
    SmallButton(
        text = stringResource(id = R.string.plus),
        modifier = Modifier
    )
