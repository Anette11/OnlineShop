package com.example.effectivemobiletesttask.navigation

sealed class NavControllerType {

    object Root : NavControllerType()

    object Main : NavControllerType()
}