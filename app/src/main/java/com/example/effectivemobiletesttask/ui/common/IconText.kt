package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
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
fun IconText(
    @DrawableRes icon: Int,
    contentDescription: String,
    text: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
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
        text = text,
        modifier = Modifier.weight(1f)
    )
}

@Composable
@Preview
fun IconTextPreview() =
    IconText(
        icon = R.drawable.ic_help,
        contentDescription = stringResource(id = R.string.empty),
        text = stringResource(id = R.string.help)
    )