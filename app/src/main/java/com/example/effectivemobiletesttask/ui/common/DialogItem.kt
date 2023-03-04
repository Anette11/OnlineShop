package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.effectivemobiletesttask.R

@Composable
fun DialogItem(
    title: String,
    description: String,
    buttonConfirmText: String,
    buttonDismissText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit,
    onDismissRequest: () -> Unit
) = Dialog(
    onDismissRequest = onDismissRequest
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen._15dp)),
        elevation = dimensionResource(id = R.dimen._8dp)
    ) {
        Column(
            modifier = Modifier.padding(all = dimensionResource(id = R.dimen._16dp))
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = dimensionResource(id = R.dimen._15sp).value.sp,
                color = colorResource(id = R.color.black_darker)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._16dp)))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = dimensionResource(id = R.dimen._13sp).value.sp,
                color = colorResource(id = R.color.gray_)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._8dp)))
            Row {
                OutlinedButton(
                    onClick = onDismissClick,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen._8dp))
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                    border = BorderStroke(
                        width = dimensionResource(id = R.dimen._2dp),
                        color = colorResource(id = R.color.blue)
                    ),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen._15dp))
                ) {
                    Text(
                        text = buttonDismissText,
                        color = colorResource(id = R.color.black),
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        fontSize = dimensionResource(id = R.dimen._13sp).value.sp
                    )
                }
                Button(
                    onClick = onConfirmClick,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen._8dp))
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue)),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen._15dp))
                ) {
                    Text(
                        text = buttonConfirmText,
                        color = colorResource(id = R.color.white),
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        fontSize = dimensionResource(id = R.dimen._13sp).value.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DialogItemPreview() =
    DialogItem(
        title = stringResource(id = R.string.logout_dialog_title),
        description = stringResource(id = R.string.logout_dialog_description),
        buttonConfirmText = stringResource(id = R.string.logout_dialog_confirm_button),
        buttonDismissText = stringResource(id = R.string.logout_dialog_dismiss_button),
        onConfirmClick = {},
        onDismissClick = {},
        onDismissRequest = {}
    )
