package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun BrandItem(
    text: String
) = Box(
    contentAlignment = Alignment.Center
) {
    Box(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen._114dp))
            .height(dimensionResource(id = R.dimen._149dp))
            .clip(shape = RoundedCornerShape(size = dimensionResource(id = R.dimen._9dp)))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.black_dark).copy(0.35f),
                        colorResource(id = R.color.black_)
                    )
                )
            )
    )
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = dimensionResource(id = R.dimen._13sp).value.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(dimensionResource(id = R.dimen._8dp))
    )
}

@Composable
@Preview
fun BrandItemPreview() =
    BrandItem(text = stringResource(id = R.string.brand))