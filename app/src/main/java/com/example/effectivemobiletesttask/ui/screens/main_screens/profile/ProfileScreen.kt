package com.example.effectivemobiletesttask.ui.screens.main_screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.DialogItem
import com.example.effectivemobiletesttask.ui.common.ScreenContent
import com.example.effectivemobiletesttask.ui.screens.ClickAction

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onShowToast: (String) -> Unit,
    onNavigateToScreen: (String) -> Unit,
    onPopBackStack: () -> Unit,
    onLogout: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.clickAction.collect { clickAction ->
            when (clickAction) {
                is ClickAction.ShowToast -> onShowToast(clickAction.message)
                is ClickAction.NavigateToScreen -> onNavigateToScreen(clickAction.route)
                ClickAction.PopBackStack -> onPopBackStack()
            }
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
            horizontalPadding = dimensionResource(id = R.dimen._28dp)
        )
        if (viewModel.showLogoutDialog) {
            DialogItem(
                title = stringResource(id = R.string.logout_dialog_title),
                description = stringResource(id = R.string.logout_dialog_description),
                buttonConfirmText = stringResource(id = R.string.logout_dialog_confirm_button),
                buttonDismissText = stringResource(id = R.string.logout_dialog_dismiss_button),
                onConfirmClick = {
                    viewModel.changeValueShowLogoutDialog()
                    onLogout()
                },
                onDismissClick = { viewModel.changeValueShowLogoutDialog() },
                onDismissRequest = { viewModel.changeValueShowLogoutDialog() }
            )
        }
    }
}