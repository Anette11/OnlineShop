package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun SimpleRow(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    showIcon: Boolean
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._15dp)))
        .background(color = colorResource(id = R.color.gray))
        .padding(horizontal = dimensionResource(id = R.dimen._8dp))
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { newValue -> onValueChange(newValue) },
        placeholder = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = placeholder,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = dimensionResource(id = R.dimen._11sp).value.sp,
                    color = colorResource(id = R.color.gray_dark),
                    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            backgroundColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.gray_dark),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = integerResource(id = R.integer._1),
        trailingIcon = {
            if (showIcon) {
                Icon(
                    painter = painterResource(id = R.drawable.eye_off),
                    contentDescription = stringResource(id = R.string.change_password_visibility)
                )
            }
        }
    )
}

@Composable
@Preview
fun SimpleRowPreview() =
    SimpleRow(
        placeholder = stringResource(id = R.string.first_name),
        value = stringResource(id = R.string.empty),
        onValueChange = {},
        showIcon = true
    )