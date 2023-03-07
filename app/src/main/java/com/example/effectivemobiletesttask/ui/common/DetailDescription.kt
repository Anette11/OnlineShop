package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun DetailDescription(
    text: String,
    horizontalPadding: Int
) = Text(
    modifier = Modifier.padding(horizontal = horizontalPadding.dp),
    text = text,
    fontFamily = FontFamily(Font(R.font.poppins_regular)),
    color = colorResource(id = R.color.gray_medium),
    fontSize = dimensionResource(id = R.dimen._9sp).value.sp
)

@Composable
@Preview
fun DetailDescriptionPreview() =
    DetailDescription(
        text = stringResource(id = R.string.description),
        horizontalPadding = integerResource(id = R.integer._24)
    )