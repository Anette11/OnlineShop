package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.clickable
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
fun ItemAdditionalInfo(
    text: String,
    onClick: () -> Unit
) = Text(
    modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() },
    text = text,
    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
    color = colorResource(id = R.color.gray_darker),
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontSize = dimensionResource(id = R.dimen._8sp).value.sp
)

@Composable
@Preview
fun ItemAdditionalInfoPreview() =
    ItemAdditionalInfo(
        text = stringResource(id = R.string.change_photo),
        onClick = {}
    )