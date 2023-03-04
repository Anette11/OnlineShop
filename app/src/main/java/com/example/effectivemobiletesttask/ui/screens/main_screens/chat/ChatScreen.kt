package com.example.effectivemobiletesttask.ui.screens.main_screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.effectivemobiletesttask.R

@Composable
fun ChatScreen() =
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white_dark)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.chat_screen))
    }