package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.effectivemobiletesttask.ui.screens.main_screens.MainScreen

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    mainNavController: NavHostController,
    startDestination: String
) = NavHost(
    navController = rootNavController,
    route = Graph.Root.route,
    startDestination = startDestination
) {
    loginNavGraph()
    composable(route = Graph.Main.route) {
        MainScreen(
            navController = mainNavController
        )
    }
}