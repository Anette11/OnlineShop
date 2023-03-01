package com.example.effectivemobiletesttask.ui.screens.main_screens.home.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.NavigateToScreen -> {
                    onNavigateToScreen(clickAction.route)
                }
                else -> {}
            }
        }
    }

    ScreenContent(
        items = viewModel.screenItems,
        horizontalPadding = dimensionResource(id = R.dimen._42dp)
    )
}