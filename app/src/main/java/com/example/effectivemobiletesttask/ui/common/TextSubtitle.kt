package com.example.effectivemobiletesttask.ui.common

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
fun TextSubtitle(
    text: String
) = Text(
    modifier = Modifier.fillMaxWidth(),
    text = text,
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    fontSize = dimensionResource(id = R.dimen._15sp).value.sp,
    color = colorResource(id = R.color.black_darker),
    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
)

@Composable
@Preview
fun TextSubtitlePreview() =
    TextSubtitle(
        text = stringResource(id = R.string.example_name)
    )
