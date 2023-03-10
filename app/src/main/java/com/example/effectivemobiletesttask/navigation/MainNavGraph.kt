package com.example.effectivemobiletesttask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.effectivemobiletesttask.ui.screens.main_screens.MainScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) = navigation(
    route = Graph.Main.route,
    startDestination = Screen.Main.route
) {
    composable(
        route = Screen.Main.route
    ) {
//        val navController = rememberNavController()
//        MainScreen(
//            navController = navController
//        )
    }
}