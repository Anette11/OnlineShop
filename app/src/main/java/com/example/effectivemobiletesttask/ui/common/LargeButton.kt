package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@Composable
fun LargeButton(
    text: String,
    onClick: () -> Unit
) = ButtonItem(
    onClick = onClick,
    content = {
        TextForButton(
            text = text,
            modifier = Modifier.fillMaxWidth()
        )
    }
)

@Composable
@Preview
fun LargeButtonPreview() =
    LargeButton(
        text = stringResource(id = R.string.sign_in),
        onClick = {}
    )