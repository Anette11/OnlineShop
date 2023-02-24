package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun LargeButtonIcon(
    text: String,
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    contentDescription: String
) = ButtonItem(
    onClick = onClick,
    content = {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                fontFamily = FontFamily(Font(R.font.montserrat_semi_bold)),
                color = colorResource(id = R.color.gray_light),
                fontSize = dimensionResource(id = R.dimen._14sp).value.sp
            )
            Icon(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                modifier = Modifier.align(Alignment.CenterStart),
                tint = colorResource(id = R.color.gray_light)
            )
        }
    }
)

@Composable
@Preview
fun LargeButtonIconPreview() =
    LargeButtonIcon(
        text = stringResource(id = R.string.upload_item),
        onClick = {},
        icon = R.drawable.ic_share,
        contentDescription = stringResource(id = R.string.empty)
    )