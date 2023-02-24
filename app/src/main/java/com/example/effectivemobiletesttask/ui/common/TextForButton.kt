package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
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
fun TextForButton(
    text: String,
    modifier: Modifier
) = Text(
    modifier = modifier,
    text = text,
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    color = colorResource(id = R.color.gray_light),
    fontSize = dimensionResource(id = R.dimen._14sp).value.sp
)

@Composable
@Preview
fun TextForButtonPreview() =
    TextForButton(
        text = stringResource(id = R.string.login),
        modifier = Modifier.fillMaxWidth()
    )