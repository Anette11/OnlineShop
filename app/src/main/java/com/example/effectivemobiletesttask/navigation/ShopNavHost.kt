package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletesttask.ui.screens.login_screens.login.LoginScreen
import com.example.effectivemobiletesttask.ui.screens.login_screens.signin.SignInScreen
import com.example.effectivemobiletesttask.ui.screens.main_screens.profile.ProfileScreen

@Composable
fun ShopNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.SingIn.route,
    onShowToast: (String) -> Unit
) = NavHost(
    navController = navController,
    startDestination = startDestination
) {
    composable(
        route = Screen.SingIn.route
    ) {
        SignInScreen(
            onShowToast = { message ->
                onShowToast(message)
            },
            onNavigateToScreen = { route ->
                navController.navigate(route = route)
            })
    }
    composable(
        route = Screen.LogIn.route
    ) {
        LoginScreen()
    }
    composable(route = Screen.Profile.route) {
        ProfileScreen()
    }
}