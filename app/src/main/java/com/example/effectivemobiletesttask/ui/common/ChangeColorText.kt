package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun ChangeColorText(
    textIsValid: String,
    textNotValid: String,
    isVisible: Boolean,
    isValid: Boolean
) {
    if (isVisible) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen._2dp)),
            text = if (isValid) textIsValid else textNotValid,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
            textAlign = TextAlign.Center,
            color = if (isValid) colorResource(id = R.color.green) else Color.Red
        )
    }
}

@Composable
@Preview
fun ChangeColorTextPreview() =
    ChangeColorText(
        textIsValid = stringResource(id = R.string.email_valid),
        textNotValid = stringResource(id = R.string.email_not_valid),
        isVisible = true,
        isValid = true
    )