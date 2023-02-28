package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.NavigateToScreen -> onNavigateToScreen(clickAction.route)
                else -> Unit
            }
        }
    }

    ScreenContent(
        items = viewModel.screenItems,
        horizontalPadding = dimensionResource(id = R.dimen._42dp)
    )
}