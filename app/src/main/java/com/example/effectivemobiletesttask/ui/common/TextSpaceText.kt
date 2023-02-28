package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun TextSpaceText(
    textStart: String,
    textEnd: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = textStart,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = dimensionResource(id = R.dimen._15sp).value.sp,
        color = colorResource(id = R.color.black_medium)
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
        text = textEnd,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = dimensionResource(id = R.dimen._9sp).value.sp,
        color = colorResource(id = R.color.gray_darker)
    )
}

@Composable
@Preview
fun TextSpaceTextPreview() =
    TextSpaceText(
        textStart = stringResource(id = R.string.latest_deals),
        textEnd = stringResource(id = R.string.view_all)
    )