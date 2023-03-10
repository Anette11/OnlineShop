package com.example.effectivemobiletesttask.util

import com.example.effectivemobiletesttask.ui.screens.ClickAction
import kotlinx.coroutines.flow.MutableSharedFlow

class ClickActionTransmitter {

    val flow = MutableSharedFlow<ClickAction>()
}