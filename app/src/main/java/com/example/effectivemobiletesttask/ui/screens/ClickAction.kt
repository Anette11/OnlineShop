package com.example.effectivemobiletesttask.ui.screens

sealed class ClickAction {

    data class InfoRow(
        val message: String
    ) : ClickAction()

    data class LargeButton(
        val message: String
    ) : ClickAction()

    data class IconTextRow(
        val message: String
    ) : ClickAction()
}