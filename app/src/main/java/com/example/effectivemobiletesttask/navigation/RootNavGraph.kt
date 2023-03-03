package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController(),
    onShowToast: (String) -> Unit,
    onClearFocus: () -> Unit
) = NavHost(
    navController = navController,
    route = Graph.Root.route,
    startDestination = Graph.Login.route
) {
    loginNavGraph(
        onShowToast = onShowToast,
        onNavigateToScreen = { route -> navController.navigate(route = route) },
        onClearFocus = onClearFocus
    )
    mainNavGraph()
}