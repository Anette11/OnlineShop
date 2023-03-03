package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Graph
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.MapKeysCreator
import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val mapKeysCreator: MapKeysCreator
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    var isLoading by mutableStateOf(false)

    private val _clearFocus = MutableSharedFlow<Boolean>()
    val clearFocus: SharedFlow<Boolean> = _clearFocus.asSharedFlow()

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._60
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.LargeTitle(
                title = resourcesProvider.getString(
                    R.string.welcome_back
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._60
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.first_name),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = {}
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._35
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.password),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = {}
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._100
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.LargeButton(
                text = resourcesProvider.getString(R.string.login),
                onClick = {
                    launch { _clickAction.emit(ClickAction.NavigateToScreen(route = Graph.Main.route)) }
                },
                isEnable = false
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._60
                )
            )
        )
        _screenItems.addAll(screenItems.values)
    }

    init {
        fillScreenItems()
    }
}