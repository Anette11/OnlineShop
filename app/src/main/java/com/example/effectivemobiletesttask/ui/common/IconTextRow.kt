package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun IconTextRow(
    @DrawableRes icon: Int,
    contentDescription: String,
    text: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._11dp)))
    Text(
        text = text,
        color = colorResource(id = R.color.black_dark),
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    )
}

@Composable
@Preview
fun IconTextRowPreview() =
    IconTextRow(
        icon = R.drawable.ic_google,
        contentDescription = stringResource(id = R.string.empty),
        text = stringResource(id = R.string.sign_in_with_google)
    )