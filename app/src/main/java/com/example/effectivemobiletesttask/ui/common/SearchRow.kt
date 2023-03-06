package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchRow(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit
) = Box(
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = dimensionResource(id = R.dimen._40dp)),
    contentAlignment = Alignment.CenterEnd
) {
    val textSelectionColors = TextSelectionColors(
        handleColor = Transparent,
        backgroundColor = colorResource(id = R.color.gray_pale)
    )
    CompositionLocalProvider(LocalTextSelectionColors provides textSelectionColors) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._12dp)))
                .background(color = colorResource(id = R.color.gray_pale)),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            enabled = true,
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            decorationBox = {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    visualTransformation = VisualTransformation.None,
                    contentPadding = PaddingValues(
                        top = dimensionResource(id = R.dimen._8dp),
                        bottom = dimensionResource(id = R.dimen._8dp),
                        start = dimensionResource(id = R.dimen._16dp),
                        end = dimensionResource(id = R.dimen._47dp)
                    ),
                    placeholder = {
                        Row(modifier = Modifier.padding(start = dimensionResource(id = R.dimen._31dp))) {
                            PlaceholderText(placeholder = placeholder)
                        }
                    },
                    innerTextField = it,
                    enabled = true,
                    singleLine = true,
                    interactionSource = MutableInteractionSource(),
                )
            }
        )
        IconButton(
            onClick = onClick,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen._16dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.what_are_you_looking_for),
                tint = colorResource(id = R.color.gray_filled)
            )
        }
    }
}

@Composable
@Preview
fun SearchRowPreview() =
    SearchRow(
        placeholder = stringResource(id = R.string.what_are_you_looking_for),
        value = stringResource(id = R.string.empty),
        onValueChange = {},
        onClick = {}
    )