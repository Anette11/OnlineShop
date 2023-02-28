package com.example.effectivemobiletesttask.ui.screens.main_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.effectivemobiletesttask.navigation.MainNavHost
import com.example.effectivemobiletesttask.ui.common.ShopBottomNavigation

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    navController: NavHostController
) = Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = {
        ShopBottomNavigation(
            items = viewModel.items,
            navController = navController,
            onNavigateToScreen = onNavigateToScreen
        )
    }
) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        MainNavHost(navController = navController)
    }
}