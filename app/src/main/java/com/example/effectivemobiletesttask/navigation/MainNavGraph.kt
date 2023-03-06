package com.example.effectivemobiletesttask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.effectivemobiletesttask.ui.screens.main_screens.MainScreen

fun NavGraphBuilder.mainNavGraph(
    onShowToast: (String) -> Unit,
    onLogout: () -> Unit,
    onClearFocus: () -> Unit
) = navigation(
    route = Graph.Main.route,
    startDestination = Screen.Main.route
) {
    composable(
        route = Screen.Main.route
    ) {
        val navController = rememberNavController()
        MainScreen(
            onNavigateToScreen = { route -> navController.doNavigation(route) },
            navController = navController,
            onShowToast = onShowToast,
            onLogout = onLogout,
            onClearFocus = onClearFocus
        )
    }
}