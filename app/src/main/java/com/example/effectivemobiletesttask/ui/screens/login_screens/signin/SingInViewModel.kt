package com.example.effectivemobiletesttask.ui.screens.login_screens.signin

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(
            0 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
            1 to ScreenItem.LargeTitle(title = resourcesProvider.getString(R.string.sign_in)),
            2 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
            3 to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.first_name),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = { newValue ->
                    onValueChange(
                        newValue = newValue,
                        index = 3
                    )
                }
            ),
            4 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            5 to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.last_name),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = { newValue ->
                    onValueChange(
                        newValue = newValue,
                        index = 5
                    )
                }
            ),
            6 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            7 to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.email),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = { newValue ->
                    onValueChange(
                        newValue = newValue,
                        index = 7
                    )
                }
            ),
            8 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            9 to ScreenItem.LargeButton(
                text = resourcesProvider.getString(R.string.sign_in),
                onClick = {
                    viewModelScope.launch {
                        _clickAction.emit(
                            ClickAction.LargeButton(
                                message = resourcesProvider.getString(
                                    R.string.sign_in
                                )
                            )
                        )
                    }
                }
            ),
            10 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._15)),
            11 to ScreenItem.InfoRow(
                textInfo = resourcesProvider.getString(R.string.already_have_an_account),
                textClickable = resourcesProvider.getString(R.string.log_in),
                onClick = {
                    viewModelScope.launch {
                        _clickAction.emit(ClickAction.NavigateToScreen(route = Screen.LogIn.route))
                    }
                }
            ),
            12 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._70)),
            13 to ScreenItem.IconTextRow(
                icon = R.drawable.ic_google,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_google),
                text = resourcesProvider.getString(R.string.sign_in_with_google),
                onClick = {
                    viewModelScope.launch {
                        _clickAction.emit(
                            ClickAction.IconTextRow(
                                message = resourcesProvider.getString(
                                    R.string.sign_in_with_google
                                )
                            )
                        )
                    }
                }
            ),
            14 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._38)),
            15 to ScreenItem.IconTextRow(
                icon = R.drawable.ic_apple,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_apple),
                text = resourcesProvider.getString(R.string.sign_in_with_apple),
                onClick = {
                    viewModelScope.launch {
                        _clickAction.emit(
                            ClickAction.IconTextRow(
                                message = resourcesProvider.getString(
                                    R.string.sign_in_with_apple
                                )
                            )
                        )
                    }
                }
            ),
            16 to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60))
        )
        _screenItems.addAll(screenItems.values)
    }

    private fun onValueChange(
        newValue: String,
        index: Int
    ) {
        val newSimpleRow = (_screenItems[index] as ScreenItem.SimpleRow).copy(value = newValue)
        _screenItems.removeAt(index)
        _screenItems.add(index, newSimpleRow)
    }

    init {
        fillScreenItems()
    }
}