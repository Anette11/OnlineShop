package com.example.effectivemobiletesttask.util

import com.example.effectivemobiletesttask.navigation.NavigationAction
import kotlinx.coroutines.flow.MutableSharedFlow

class NavigationActionTransmitter {

    val flow = MutableSharedFlow<NavigationAction>()
}