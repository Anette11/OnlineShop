package com.example.effectivemobiletesttask.ui.screens.main_screens.profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import com.example.effectivemobiletesttask.navigation.NavigationAction
import com.example.effectivemobiletesttask.ui.common.DialogItem
import com.example.effectivemobiletesttask.ui.common.ScreenContent

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    onPopBackStack: () -> Unit,
    onLogout: () -> Unit
) {
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { newPhotoUri -> viewModel.changePhotoUri(newPhotoUri = newPhotoUri) }
    )

    LaunchedEffect(key1 = true) {
        viewModel.navigationAction.collect { navigationAction ->
            when (navigationAction) {
                is NavigationAction.NavigateToScreen -> onNavigateToScreen(navigationAction.route)
                NavigationAction.PopBackStack -> onPopBackStack()
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.pickPhotoFromGallery.collect {
            photoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
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
                    viewModel.updateLoggedInUser()
                    onLogout()
                },
                onDismissClick = { viewModel.changeValueShowLogoutDialog() },
                onDismissRequest = { viewModel.changeValueShowLogoutDialog() }
            )
        }
    }
}