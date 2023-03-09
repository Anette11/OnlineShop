package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String
) = NavHost(
    navController = navController,
    route = Graph.Root.route,
    startDestination = startDestination
) {
    loginNavGraph(
        onNavigateToScreen = { route -> navController.doNavigation(route = route) }
    )
    mainNavGraph(
        onLogout = { navController.doNavigation(route = Graph.Root.route) }
    )
}