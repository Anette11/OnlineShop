package com.example.effectivemobiletesttask.ui.screens

sealed class ClickAction {

    data class ShowToast(
        val message: String
    ) : ClickAction()

    data class Share(
        val image: String
    ) : ClickAction()

    object GoogleSignIn
        : ClickAction()

    object ClearFocus
        : ClickAction()
}