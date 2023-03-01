package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun IconTextIconLarge(
    @DrawableRes iconLeft: Int,
    contentDescription: String,
    textMain: String,
    textAdditional: String,
    @DrawableRes iconRight: Int,
    contentDescriptionRight: String,
    size: Int,
    borderWidth: Int,
    @ColorRes color: Int
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        painter = painterResource(id = iconLeft),
        contentDescription = contentDescription,
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = R.color.black_dark),
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    fontSize = dimensionResource(id = R.dimen._20sp).value.sp
                )
            ) {
                append(textMain)
            }
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = R.color.blue),
                    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                    fontSize = dimensionResource(id = R.dimen._20sp).value.sp
                )
            ) {
                append(textAdditional)
            }
        },
        textAlign = TextAlign.Center,
        modifier = Modifier.weight(1f)
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    ImageInCircle(
        icon = iconRight,
        contentDescription = contentDescriptionRight,
        size = size,
        borderWidth = borderWidth,
        color = color
    )
}

@Composable
@Preview
fun IconTextIconLargePreview() =
    IconTextIconLarge(
        iconLeft = R.drawable.ic_menu,
        contentDescription = stringResource(id = R.string.empty),
        textMain = stringResource(id = R.string.trade_by),
        textAdditional = stringResource(id = R.string.bata),
        iconRight = R.drawable.ic_launcher_foreground,
        contentDescriptionRight = stringResource(id = R.string.empty),
        size = integerResource(id = R.integer._31),
        borderWidth = integerResource(id = R.integer._2),
        color = R.color.gray_lighter
    )