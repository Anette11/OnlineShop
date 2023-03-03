package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun LargeButton(
    text: String,
    onClick: () -> Unit,
    isEnable: Boolean
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
        .clickable { if (isEnable) onClick() }
        .background(
            color = if (isEnable) colorResource(id = R.color.blue)
            else Color.LightGray
        )
        .padding(dimensionResource(id = R.dimen._14dp)),
    horizontalArrangement = Arrangement.Center
) {
    TextForButton(
        text = text,
        modifier = Modifier
    )
}

@Composable
@Preview
fun LargeButtonPreview() =
    LargeButton(
        text = stringResource(id = R.string.sign_in),
        onClick = {},
        isEnable = true
    )