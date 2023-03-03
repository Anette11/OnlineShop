package com.example.effectivemobiletesttask.ui.screens.login_screens.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ProgressBar
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun SignInScreen(
    viewModel: SingInViewModel = hiltViewModel(),
    onShowToast: (String) -> Unit,
    onNavigateToScreen: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.LargeButton -> onShowToast(clickAction.message)
                is ClickAction.IconTextRow -> onShowToast(clickAction.message)
                is ClickAction.NavigateToScreen -> onNavigateToScreen(clickAction.route)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ScreenContent(
            items = viewModel.screenItems,
            horizontalPadding = dimensionResource(id = R.dimen._42dp)
        )
        if (viewModel.isLoading) ProgressBar()
    }
}