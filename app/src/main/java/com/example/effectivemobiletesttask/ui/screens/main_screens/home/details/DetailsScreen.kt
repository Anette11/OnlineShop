package com.example.effectivemobiletesttask.ui.screens.main_screens.home.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.BottomSheet
import com.example.effectivemobiletesttask.ui.common.ProgressBar
import com.example.effectivemobiletesttask.ui.common.ScreenContent

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel()
) = BottomSheet(
    quantity = viewModel.addToCartItem.quantity,
    amount = viewModel.addToCartItem.amountString,
    onIncreaseClick = viewModel.addToCartItem.onIncreaseClick,
    onDecreaseClick = viewModel.addToCartItem.onDecreaseClick,
    onAddToCardCardClick = viewModel.addToCartItem.onAddToCardCardClick,
    content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white_dark)),
            contentAlignment = Alignment.Center
        ) {
            ScreenContent(
                items = viewModel.screenItems,
                horizontalPadding = dimensionResource(id = R.dimen._0dp)
            )
            if (viewModel.isLoading) ProgressBar()
        }
    }
)