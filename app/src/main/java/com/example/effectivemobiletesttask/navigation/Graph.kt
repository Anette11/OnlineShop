package com.example.effectivemobiletesttask.navigation

sealed class Graph(
    val route: String
) {
    object Root : Graph(route = "root_graph")
    object Login : Graph(route = "login_graph")
    object Main : Graph(route = "main_graph")
}