package com.example.effectivemobiletesttask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletesttask.ui.screens.login.LoginScreen
import com.example.effectivemobiletesttask.ui.screens.signin.SignInScreen

@Composable
fun ShopNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.SingIn.route
) = NavHost(
    navController = navController,
    startDestination = startDestination
) {
    composable(
        route = Screen.SingIn.route
    ) {
        SignInScreen()
    }
    composable(
        route = Screen.LogIn.route
    ) {
        LoginScreen()
    }
}