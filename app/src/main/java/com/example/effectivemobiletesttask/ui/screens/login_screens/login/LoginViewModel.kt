package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Graph
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private val _clearFocus = MutableSharedFlow<Boolean>()
    val clearFocus: SharedFlow<Boolean> = _clearFocus.asSharedFlow()

    var isLoading by mutableStateOf(false)

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
        ScreenItem.LargeTitle(title = resourcesProvider.getString(R.string.welcome_back)),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.first_name),
            value = resourcesProvider.getString(R.string.empty),
            onValueChange = {}
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.password),
            value = resourcesProvider.getString(R.string.empty),
            onValueChange = {}
        ),
        ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._100)),
        ScreenItem.LargeButton(
            text = resourcesProvider.getString(R.string.login),
            onClick = {
                launch { _clickAction.emit(ClickAction.NavigateToScreen(route = Graph.Main.route)) }
            },
            isEnable = false
        )
    )
}