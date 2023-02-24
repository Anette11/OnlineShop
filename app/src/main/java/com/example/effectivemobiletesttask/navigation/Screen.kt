package com.example.effectivemobiletesttask.navigation

sealed class Screen(
    val route: String
) {
    object LogIn : Screen(route = "log_in_screen")
    object SingIn : Screen(route = "sign_in_screen")
    object Profile : Screen(route = "profile_screen")
}