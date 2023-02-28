package com.example.effectivemobiletesttask.navigation

import androidx.annotation.DrawableRes
import com.example.effectivemobiletesttask.R

sealed class Screen(
    val route: String,
    @DrawableRes val icon: Int?
) {
    object LogIn : Screen(
        route = "log_in_screen",
        icon = null
    )

    object SingIn : Screen(
        route = "sign_in_screen",
        icon = null
    )

    object Home : Screen(
        icon = R.drawable.ic_home,
        route = "home_screen"
    )

    object Favourite : Screen(
        icon = R.drawable.ic_favourite,
        route = "favourite_screen"
    )

    object Shopping : Screen(
        icon = R.drawable.ic_shopping,
        route = "shopping_screen"
    )

    object Chat : Screen(
        icon = R.drawable.ic_chat,
        route = "chat_screen"
    )

    object Profile : Screen(
        icon = R.drawable.ic_profile,
        route = "profile_screen"
    )
}