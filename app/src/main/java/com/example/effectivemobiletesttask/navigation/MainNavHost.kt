package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.effectivemobiletesttask.ui.screens.main_screens.chat.ChatScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.favourite.FavouriteScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.home.details.DetailsScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.home.home.HomeScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.profile.ProfileScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.shopping.ShoppingScreen

@Composable
fun MainNavHost(
    navController: NavHostController
) = NavHost(
    navController = navController,
    startDestination = Screen.Home.route
) {
    composable(
        route = Screen.Home.route
    ) {
        HomeScreen(
            onNavigateToScreen = { route -> navController.navigate(route = route) }
        )
    }
    composable(
        route = Screen.Details.route
    ) {
        DetailsScreen()
    }
    composable(
        route = Screen.Favourite.route
    ) {
        FavouriteScreen()
    }
    composable(
        route = Screen.Shopping.route
    ) {
        ShoppingScreen()
    }
    composable(
        route = Screen.Chat.route
    ) {
        ChatScreen()
    }
    composable(
        route = Screen.Profile.route
    ) {
        ProfileScreen()
    }
}