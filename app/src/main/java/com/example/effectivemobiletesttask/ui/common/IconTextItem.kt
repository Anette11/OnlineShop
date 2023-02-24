package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun IconTextItem(
    @DrawableRes iconLeft: Int,
    @DrawableRes iconRight: Int,
    contentDescriptionLeft: String,
    contentDescriptionRight: String,
    text: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    IconInCircle(
        icon = iconLeft,
        contentDescription = contentDescriptionLeft
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    TextProfile(
        text = text,
        modifier = Modifier.weight(1f)
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    Icon(
        painter = painterResource(id = iconRight),
        contentDescription = contentDescriptionRight
    )
}

@Composable
@Preview
fun IconTextItemPreview() =
    IconTextItem(
        iconLeft = R.drawable.ic_credit_card,
        iconRight = R.drawable.arrow_right,
        contentDescriptionLeft = stringResource(id = R.string.empty),
        contentDescriptionRight = stringResource(id = R.string.empty),
        text = stringResource(id = R.string.trade_store)
    )
