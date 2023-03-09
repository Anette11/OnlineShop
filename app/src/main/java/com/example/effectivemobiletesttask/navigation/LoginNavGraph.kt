package com.example.effectivemobiletesttask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.effectivemobiletesttask.ui.screens.login_screens.login.LoginScreen
import com.example.effectivemobiletesttask.ui.screens.login_screens.signin.SignInScreen

fun NavGraphBuilder.loginNavGraph(
    onShowToast: (String) -> Unit,
    onNavigateToScreen: (String) -> Unit,
    onClearFocus: () -> Unit,
    onGoogleSignIn: () -> Unit
) = navigation(
    route = Graph.Login.route,
    startDestination = Screen.SingIn.route
) {
    composable(
        route = Screen.SingIn.route
    ) {
        SignInScreen(
            onShowToast = onShowToast,
            onNavigateToScreen = onNavigateToScreen,
            onClearFocus = onClearFocus,
            onGoogleSignIn = onGoogleSignIn
        )
    }
    composable(
        route = Screen.LogIn.route
    ) {
        LoginScreen(
            onShowToast = onShowToast,
            onNavigateToScreen = onNavigateToScreen,
            onClearFocus = onClearFocus
        )
    }
}