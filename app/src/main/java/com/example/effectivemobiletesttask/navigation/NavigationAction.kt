package com.example.effectivemobiletesttask.navigation

sealed class NavigationAction {

    data class NavigateToScreen(
        val route: String
    ) : NavigationAction()

    object PopBackStack
        : NavigationAction()
}