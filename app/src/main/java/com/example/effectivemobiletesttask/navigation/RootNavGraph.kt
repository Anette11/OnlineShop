package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController(),
    onShowToast: (String) -> Unit,
    onClearFocus: () -> Unit,
    startDestination: String,
    onShareClick: (String) -> Unit,
    onGoogleSignIn: () -> Unit
) = NavHost(
    navController = navController,
    route = Graph.Root.route,
    startDestination = startDestination
) {
    loginNavGraph(
        onShowToast = onShowToast,
        onNavigateToScreen = { route -> navController.doNavigation(route = route) },
        onClearFocus = onClearFocus,
        onGoogleSignIn = onGoogleSignIn
    )
    mainNavGraph(
        onShowToast = onShowToast,
        onLogout = { navController.doNavigation(route = Graph.Root.route) },
        onClearFocus = onClearFocus,
        onShareClick = onShareClick
    )
}