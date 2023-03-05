package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.GetUserByFirstNameUseCase
import com.example.domain.use_cases.SaveUserUseCase
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
    private val mapKeysCreator: MapKeysCreator,
    private val getUserByFirstNameUseCase: GetUserByFirstNameUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    var isLoading by mutableStateOf(false)

    private val _clearFocus = MutableSharedFlow<Boolean>()
    val clearFocus: SharedFlow<Boolean> = _clearFocus.asSharedFlow()

    private var indexFirstName = 0
    private var indexPassword = 0
    private var indexLoginButton = 0

    private fun onLogin() = launch {
        try {
            _clearFocus.emit(true)
            isLoading = true
            updateLoginEnable()
            val firstName = (_screenItems[indexFirstName] as ScreenItem.SimpleRow).value
            val userExisting = getUserByFirstNameUseCase.invoke(firstName = firstName)
            if (userExisting == null) {
                _clickAction.emit(
                    value = ClickAction.ShowToast(
                        message = resourcesProvider.getString(
                            R.string.user_not_found
                        )
                    )
                )
                return@launch
            }
            val updatedUser = userExisting.copy(isLoggedIn = true)
            saveUserUseCase.invoke(user = updatedUser)
            _clickAction.emit(ClickAction.NavigateToScreen(route = Graph.Main.route))
        } catch (e: Exception) {
            _clickAction.emit(
                value = ClickAction.ShowToast(
                    message = resourcesProvider.getString(
                        R.string.user_not_found
                    )
                )
            )
        } finally {
            isLoading = false
            updateLoginEnable()
        }
    }

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
            mapKeysCreator.createMapKey().apply { indexFirstName = this } to ScreenItem.SimpleRow(
                placeholder = resourcesProvider.getString(R.string.first_name),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = { newValue ->
                    onValueChange(
                        newValue = newValue,
                        index = indexFirstName
                    )
                    updateLoginEnable()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._35
                )
            ),
            mapKeysCreator.createMapKey().apply { indexPassword = this } to ScreenItem.PasswordRow(
                placeholder = resourcesProvider.getString(R.string.password),
                value = resourcesProvider.getString(R.string.empty),
                onValueChange = { newValue ->
                    onPasswordValueChange(newValue = newValue)
                    updateLoginEnable()
                },
                isPasswordVisible = false,
                onTogglePasswordClick = { onTogglePasswordClick() }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._100
                )
            ),
            mapKeysCreator.createMapKey()
                .apply { indexLoginButton = this } to ScreenItem.LargeButton(
                text = resourcesProvider.getString(R.string.login),
                onClick = { onLogin() },
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

    private fun onValueChange(
        newValue: String,
        index: Int
    ) {
        val newSimpleRow = (_screenItems[index] as ScreenItem.SimpleRow).copy(value = newValue)
        _screenItems.removeAt(index)
        _screenItems.add(index, newSimpleRow)
    }

    private fun onPasswordValueChange(
        newValue: String
    ) {
        val newSimpleRow =
            (_screenItems[indexPassword] as ScreenItem.PasswordRow).copy(value = newValue)
        _screenItems.removeAt(indexPassword)
        _screenItems.add(indexPassword, newSimpleRow)
    }

    private fun onTogglePasswordClick() {
        val isPasswordVisible =
            (_screenItems[indexPassword] as ScreenItem.PasswordRow).isPasswordVisible
        val newSimpleRow =
            (_screenItems[indexPassword] as ScreenItem.PasswordRow).copy(isPasswordVisible = isPasswordVisible.not())
        _screenItems.removeAt(indexPassword)
        _screenItems.add(indexPassword, newSimpleRow)
    }

    private fun updateLoginEnable() {
        val firstName = (_screenItems[indexFirstName] as ScreenItem.SimpleRow).value
        val password = (_screenItems[indexPassword] as ScreenItem.PasswordRow).value
        val isLoginEnable = firstName.trim().isNotBlank() &&
                password.trim().isNotBlank() &&
                isLoading.not()
        val updateLoginButton =
            (_screenItems[indexLoginButton] as ScreenItem.LargeButton).copy(isEnable = isLoginEnable)
        _screenItems.removeAt(indexLoginButton)
        _screenItems.add(indexLoginButton, updateLoginButton)
    }

    init {
        fillScreenItems()
    }
}