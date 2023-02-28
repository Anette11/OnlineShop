package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun IconInCircleWithHint(
    @DrawableRes icon: Int,
    contentDescription: String,
    hint: String
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    IconInCircle(
        icon = icon,
        contentDescription = contentDescription,
        height = integerResource(id = R.integer._42),
        width = integerResource(id = R.integer._42)
    )
    SpacerRow(height = integerResource(id = R.integer._11))
    Text(
        text = hint,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = dimensionResource(id = R.dimen._8sp).value.sp,
        color = colorResource(id = R.color.gray_strong),
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
fun IconInCircleWithHintPreview() =
    IconInCircleWithHint(
        icon = R.drawable.ic_phone,
        contentDescription = stringResource(id = R.string.empty),
        hint = stringResource(id = R.string.phones)
    )