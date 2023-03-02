package com.example.effectivemobiletesttask.ui.screens.main_screens.home.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.ScreenContent

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel()
) = ScreenContent(
    items = viewModel.screenItems,
    horizontalPadding = dimensionResource(id = R.dimen._42dp)
)