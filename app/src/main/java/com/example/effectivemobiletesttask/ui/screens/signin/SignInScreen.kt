package com.example.effectivemobiletesttask.ui.screens.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun SignInScreen(
    viewModel: SingInViewModel = hiltViewModel(),
    onShowToast: (String) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.InfoRow -> onShowToast(clickAction.message)
                is ClickAction.LargeButton -> onShowToast(clickAction.message)
                is ClickAction.IconTextRow -> onShowToast(clickAction.message)
            }
        }
    }

    ScreenContent(
        items = viewModel.screenItems,
        horizontalPadding = dimensionResource(id = R.dimen._42dp)
    )
}