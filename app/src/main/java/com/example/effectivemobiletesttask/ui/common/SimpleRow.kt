package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.effectivemobiletesttask.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SimpleRow(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions
) = BasicTextField(
    modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
        .background(color = colorResource(id = R.color.gray)),
    value = value,
    onValueChange = onValueChange,
    singleLine = true,
    enabled = true,
    keyboardOptions = keyboardOptions,
    decorationBox = {
        TextFieldDefaults.TextFieldDecorationBox(
            value = value,
            visualTransformation = VisualTransformation.None,
            contentPadding = PaddingValues(
                vertical = dimensionResource(id = R.dimen._8dp),
                horizontal = dimensionResource(id = R.dimen._16dp)
            ),
            placeholder = { PlaceholderText(placeholder = placeholder) },
            innerTextField = it,
            enabled = true,
            singleLine = true,
            interactionSource = MutableInteractionSource()
        )
    }
)

@Composable
@Preview
fun SimpleRowPreview() =
    SimpleRow(
        placeholder = stringResource(id = R.string.first_name),
        value = stringResource(id = R.string.empty),
        onValueChange = {},
        keyboardOptions = KeyboardOptions()
    )