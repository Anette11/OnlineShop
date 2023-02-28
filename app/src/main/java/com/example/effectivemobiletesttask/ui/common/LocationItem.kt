package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun LocationItem(
    text: String,
    @DrawableRes icon: Int,
    contentDescription: String
) = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = text,
        color = colorResource(id = R.color.gray_),
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontSize = dimensionResource(id = R.dimen._10dp).value.sp,
        modifier = Modifier.weight(1f),
        textAlign = TextAlign.End
    )
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen._2dp)))
    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription
    )
}

@Composable
@Preview
fun LocationItemPreview() =
    LocationItem(
        text = stringResource(id = R.string.location),
        icon = R.drawable.ic_arrow_down,
        contentDescription = stringResource(id = R.string.empty)
    )