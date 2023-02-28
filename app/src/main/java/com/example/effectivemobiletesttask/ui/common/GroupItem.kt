package com.example.effectivemobiletesttask.ui.common

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun GroupItem(
    text: String,
    @ColorRes color: Int,
    radius: Int,
    fontSize: Int
) = Row(
    modifier = Modifier
        .clip(shape = RoundedCornerShape(size = radius.dp))
        .background(color = colorResource(id = color))
        .padding(
            horizontal = dimensionResource(id = R.dimen._8dp),
            vertical = dimensionResource(id = R.dimen._2dp)
        )
) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        color = colorResource(id = R.color.black_extra),
        fontSize = fontSize.sp
    )
}

@Composable
@Preview
fun GroupItemPreview() =
    GroupItem(
        text = stringResource(id = R.string.kids),
        color = R.color.gray_half_transparent,
        radius = integerResource(id = R.integer._5),
        fontSize = integerResource(id = R.integer._6)
    )