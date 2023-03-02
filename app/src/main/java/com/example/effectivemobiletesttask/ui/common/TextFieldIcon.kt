package com.example.effectivemobiletesttask.ui.common

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun TextFieldIcon(
    showText: Boolean,
    isVisible: Boolean
) = Icon(
    painter = painterResource(id = if (showText) R.drawable.eye_on else R.drawable.eye_off),
    contentDescription = stringResource(id = R.string.change_password_visibility),
    tint = if (isVisible) colorResource(id = R.color.gray_filled) else Color.Transparent
)

@Composable
@Preview
fun TextFieldIconPreview() =
    TextFieldIcon(
        showText = true,
        isVisible = true
    )