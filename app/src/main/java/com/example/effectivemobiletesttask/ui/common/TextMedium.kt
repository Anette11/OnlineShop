package com.example.effectivemobiletesttask.ui.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.effectivemobiletesttask.R

@Composable
fun TextMedium(
    text: String,
    modifier: Modifier
) = Text(
    text = text,
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontSize = dimensionResource(id = R.dimen._14sp).value.sp,
    color = colorResource(id = R.color.black_medium),
    modifier = modifier
)
