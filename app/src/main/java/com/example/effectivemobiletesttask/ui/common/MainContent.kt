package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletesttask.MainActivityViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.*
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.util.ClickActionTransmitter
import com.example.effectivemobiletesttask.util.NavigationActionTransmitter

@Composable
fun MainContent(
    clickActionTransmitter: ClickActionTransmitter,
    navigationActionTransmitter: NavigationActionTransmitter,
    onGoogleSignIn: () -> Unit,
    onShareClick: (String) -> Unit,
    showToast: (String) -> Unit
) {
    val viewModel: MainActivityViewModel = hiltViewModel()
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white_dark))
    ) {
        LaunchedEffect(key1 = true) {
            clickActionTransmitter.flow.collect { clickSAction ->
                when (clickSAction) {
                    ClickAction.ClearFocus -> focusManager.clearFocus()
                    ClickAction.GoogleSignIn -> onGoogleSignIn()
                    is ClickAction.Share -> onShareClick(clickSAction.image)
                    is ClickAction.ShowToast -> showToast(clickSAction.message)
                }
            }
        }

        val rootNavController: NavHostController = rememberNavController()
        val mainNavController: NavHostController = rememberNavController()

        fun findNavController(
            navControllerType: NavControllerType
        ): NavHostController = when (navControllerType) {
            NavControllerType.Root -> rootNavController
            NavControllerType.Main -> mainNavController
        }

        LaunchedEffect(key1 = true) {
            navigationActionTransmitter.flow.collect { navigationAction ->
                when (navigationAction) {
                    is NavigationAction.Logout -> findNavController(navigationAction.navControllerType)
                        .logout()
                    is NavigationAction.NavigateToScreen -> findNavController(navigationAction.navControllerType)
                        .doNavigation(route = navigationAction.route)
                    is NavigationAction.PopBackStack -> findNavController(navigationAction.navControllerType)
                        .popBackStack()
                }
            }
        }

        RootNavGraph(
            rootNavController = rootNavController,
            mainNavController = mainNavController,
            startDestination = if (viewModel.checkIfUserIsLoggedIn()) Graph.Main.route
            else Graph.Login.route
        )
    }
}