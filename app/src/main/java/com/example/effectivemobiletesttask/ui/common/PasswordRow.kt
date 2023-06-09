package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PasswordRow(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onTogglePasswordClick: () -> Unit
) = Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.CenterEnd
) {
    val textSelectionColors = TextSelectionColors(
        handleColor = Color.Transparent,
        backgroundColor = colorResource(id = R.color.gray_pale)
    )
    CompositionLocalProvider(LocalTextSelectionColors provides textSelectionColors) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
                .background(color = colorResource(id = R.color.gray)),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            enabled = true,
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            decorationBox = {
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
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
                    interactionSource = MutableInteractionSource()
                )
            }
        )
        IconButton(
            onClick = onTogglePasswordClick,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen._16dp))
        ) {
            Icon(
                painter = painterResource(
                    id = if (isPasswordVisible) R.drawable.eye_on
                    else R.drawable.eye_off
                ),
                contentDescription = stringResource(
                    id = if (isPasswordVisible) R.string.password_hide
                    else R.string.password_show
                ),
                tint = colorResource(id = R.color.gray_filled)
            )
        }
    }
}

@Composable
@Preview
fun PasswordRowPreview() =
    PasswordRow(
        placeholder = stringResource(id = R.string.password),
        value = stringResource(id = R.string.empty),
        onValueChange = {},
        isPasswordVisible = true,
        onTogglePasswordClick = {}
    )
