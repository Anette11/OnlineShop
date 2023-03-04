package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun IconTextText(
    @DrawableRes icon: Int,
    contentDescription: String,
    textCenter: String,
    textRight: String,
    onClick: () -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() },
    verticalAlignment = Alignment.CenterVertically
) {
    IconInCircle(
        icon = icon,
        contentDescription = contentDescription,
        height = integerResource(id = R.integer._40),
        width = integerResource(id = R.integer._40)
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    TextMedium(
        text = textCenter,
        modifier = Modifier.weight(1f)
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._8dp)))
    TextMedium(
        text = textRight,
        modifier = Modifier
    )
}

@Composable
@Preview
fun IconTextTextPreview() =
    IconTextText(
        icon = R.drawable.ic_credit_card,
        contentDescription = stringResource(id = R.string.empty),
        textCenter = stringResource(id = R.string.balance),
        textRight = stringResource(id = R.string.balance_value),
        onClick = {}
    )