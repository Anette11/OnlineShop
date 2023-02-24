package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ScreenContent

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) = ScreenContent(
    items = viewModel.screenItems,
    horizontalPadding = dimensionResource(id = R.dimen._42dp)
)