package com.example.effectivemobiletesttask.navigation

sealed class NavigationAction {

    data class NavigateToScreen(
        val route: String,
        val navControllerType: NavControllerType
    ) : NavigationAction()

    data class PopBackStack(
        val navControllerType: NavControllerType
    ) : NavigationAction()

    data class Logout(
        val navControllerType: NavControllerType
    ) : NavigationAction()
}