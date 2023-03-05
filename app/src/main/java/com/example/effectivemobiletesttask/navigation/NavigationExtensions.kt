package com.example.effectivemobiletesttask.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.doNavigation(
    route: String
) = this.navigate(
    route = route
) {
    popUpTo(this@doNavigation.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}