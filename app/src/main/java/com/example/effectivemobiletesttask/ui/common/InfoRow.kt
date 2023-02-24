package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun InfoRow(
    textInfo: String,
    textClickable: String,
    onClick: () -> Unit
) = Row(modifier = Modifier.fillMaxWidth()) {
    Text(
        text = textInfo,
        color = colorResource(id = R.color.gray_medium),
        fontSize = dimensionResource(id = R.dimen._10sp).value.sp,
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Text(
        modifier = Modifier.clickable { onClick() },
        text = textClickable,
        color = colorResource(id = R.color.blue_light),
        fontSize = dimensionResource(id = R.dimen._10sp).value.sp,
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    )
}

@Composable
@Preview
fun InfoRowPreview() =
    InfoRow(
        textInfo = "Already have an account?",
        textClickable = "Log in",
        onClick = {}
    )