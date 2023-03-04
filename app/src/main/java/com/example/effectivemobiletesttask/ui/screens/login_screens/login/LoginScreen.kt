package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ProgressBar
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onShowToast: (String) -> Unit,
    onNavigateToScreen: (String) -> Unit,
    onClearFocus: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.ShowToast -> onShowToast(clickAction.message)
                is ClickAction.NavigateToScreen -> onNavigateToScreen(clickAction.route)
                else -> Unit
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.clearFocus.collect {
            if (it) onClearFocus()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white_dark)),
        contentAlignment = Alignment.Center
    ) {
        ScreenContent(
            items = viewModel.screenItems,
            horizontalPadding = dimensionResource(id = R.dimen._42dp)
        )
        if (viewModel.isLoading) ProgressBar()
    }
}