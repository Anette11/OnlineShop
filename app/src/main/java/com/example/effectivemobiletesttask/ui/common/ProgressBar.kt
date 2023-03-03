package com.example.effectivemobiletesttask.ui.common

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProgressBar() =
    CircularProgressIndicator(color = Color.Black)

@Composable
@Preview
fun ProgressBarPreview() =
    ProgressBar()