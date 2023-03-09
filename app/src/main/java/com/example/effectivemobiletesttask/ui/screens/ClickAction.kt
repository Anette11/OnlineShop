package com.example.effectivemobiletesttask.ui.screens

sealed class ClickAction {

    data class ShowToast(
        val message: String
    ) : ClickAction()

    data class NavigateToScreen(
        val route: String
    ) : ClickAction()

    data class Share(
        val image: String
    ) : ClickAction()

    object PopBackStack
        : ClickAction()

    object GoogleSignIn
        : ClickAction()
}