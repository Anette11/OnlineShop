package com.example.effectivemobiletesttask.ui.screens.login_screens.signin

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
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.LargeTitle(title = resourcesProvider.getString(R.string.sign_in)),
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.first_name),
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.last_name),
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.email),
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.LargeButton(
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
        ScreenItem.SpacerRow(height = 15),
        ScreenItem.InfoRow(
            textInfo = resourcesProvider.getString(R.string.already_have_an_account),
            textClickable = resourcesProvider.getString(R.string.log_in),
            onClick = {
                viewModelScope.launch {
                    _clickAction.emit(ClickAction.NavigateToScreen(route = Screen.LogIn.route))
                }
            }
        ),
        ScreenItem.SpacerRow(height = 70),
        ScreenItem.IconTextRow(
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
        ScreenItem.SpacerRow(height = 38),
        ScreenItem.IconTextRow(
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
        ScreenItem.SpacerRow(height = 60)
    )
}