package com.example.effectivemobiletesttask.ui.screens.main_screens

import androidx.lifecycle.ViewModel
import com.example.data.remote.DispatchersProvider
import com.example.effectivemobiletesttask.navigation.NavigationAction
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.util.NavigationActionTransmitter
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigationActionTransmitter: NavigationActionTransmitter,
    private val dispatchersProvider: DispatchersProvider
) : ViewModel() {

    val items = listOf(
        Screen.Home,
        Screen.Favourite,
        Screen.Shopping,
        Screen.Chat,
        Screen.Profile
    )

    fun onNavigationAction(
        navigationAction: NavigationAction
    ) = launch(dispatchersProvider.io) {
        navigationActionTransmitter.flow.emit(navigationAction)
    }
}