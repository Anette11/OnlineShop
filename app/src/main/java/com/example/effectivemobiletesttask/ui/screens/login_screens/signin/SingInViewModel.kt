package com.example.effectivemobiletesttask.ui.screens.login_screens.signin

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.EmailValidator
import com.example.effectivemobiletesttask.util.ResourcesProvider
import com.example.effectivemobiletesttask.util.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val emailValidator: EmailValidator
) : ViewModel() {

    private val _clickAction: MutableSharedFlow<ClickAction> = MutableSharedFlow()
    val clickAction: SharedFlow<ClickAction> = _clickAction.asSharedFlow()

    private var _screenItems = mutableStateListOf<ScreenItem>()
    val screenItems = _screenItems

    private var counter = -1
    private var indexFirstName = 0
    private var indexLastName = 0
    private var indexEmail = 0
    private var indexChangeColorText = 0
    private var indexSignInButton = 0

    private fun createMapKey(): Int {
        counter += 1
        return counter
    }

    private fun fillScreenItems() {
        val screenItems = sortedMapOf(
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
            createMapKey() to ScreenItem.LargeTitle(title = resourcesProvider.getString(R.string.sign_in)),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60)),
            createMapKey().apply { indexFirstName = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.first_name),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexFirstName
                            )
                            updateSignInEnable(
                                indexFirstName = indexFirstName,
                                indexLastName = indexLastName,
                                indexEmail = indexEmail,
                                indexSignInButton = indexSignInButton
                            )
                        }
                    ),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            createMapKey().apply { indexLastName = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.last_name),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexLastName
                            )
                            updateSignInEnable(
                                indexFirstName = indexFirstName,
                                indexLastName = indexLastName,
                                indexEmail = indexEmail,
                                indexSignInButton = indexSignInButton
                            )
                        }
                    ),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            createMapKey().apply { indexEmail = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.email),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexEmail
                            )
                            onEmailChange(
                                newEmail = newValue,
                                indexChangeColorText = indexChangeColorText
                            )
                            updateSignInEnable(
                                indexFirstName = indexFirstName,
                                indexLastName = indexLastName,
                                indexEmail = indexEmail,
                                indexSignInButton = indexSignInButton
                            )
                        }
                    ),
            createMapKey().apply { indexChangeColorText = this } to
                    ScreenItem.ChangeColorText(
                        textIsValid = resourcesProvider.getString(R.string.email_valid),
                        textNotValid = resourcesProvider.getString(R.string.email_not_valid),
                        isVisible = false,
                        isValid = false
                    ),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._35)),
            createMapKey().apply { indexSignInButton = this } to
                    ScreenItem.LargeButton(
                        text = resourcesProvider.getString(R.string.sign_in),
                        onClick = {
                            launch {
                                _clickAction.emit(
                                    ClickAction.LargeButton(
                                        message = resourcesProvider.getString(
                                            R.string.sign_in
                                        )
                                    )
                                )
                            }
                        },
                        isEnable = false
                    ),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._15)),
            createMapKey() to ScreenItem.InfoRow(
                textInfo = resourcesProvider.getString(R.string.already_have_an_account),
                textClickable = resourcesProvider.getString(R.string.log_in),
                onClick = {
                    launch {
                        _clickAction.emit(ClickAction.NavigateToScreen(route = Screen.LogIn.route))
                    }
                }
            ),
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._70)),
            createMapKey() to ScreenItem.IconTextRow(
                icon = R.drawable.ic_google,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_google),
                text = resourcesProvider.getString(R.string.sign_in_with_google),
                onClick = {
                    launch {
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
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._38)),
            createMapKey() to ScreenItem.IconTextRow(
                icon = R.drawable.ic_apple,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_apple),
                text = resourcesProvider.getString(R.string.sign_in_with_apple),
                onClick = {
                    launch {
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
            createMapKey() to ScreenItem.SpacerRow(height = resourcesProvider.getInteger(R.integer._60))
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

    private fun onEmailChange(
        newEmail: String,
        indexChangeColorText: Int
    ) {
        val isEmailVisible = newEmail.isNotEmpty()
        val isEmailValid = emailValidator.isEmailValid(email = newEmail)
        val newChangeColorText =
            (_screenItems[indexChangeColorText] as ScreenItem.ChangeColorText).copy(
                isVisible = isEmailVisible,
                isValid = isEmailValid
            )
        _screenItems.removeAt(indexChangeColorText)
        _screenItems.add(indexChangeColorText, newChangeColorText)
    }

    private fun updateSignInEnable(
        indexFirstName: Int,
        indexLastName: Int,
        indexEmail: Int,
        indexSignInButton: Int
    ) {
        val firstName = (_screenItems[indexFirstName] as ScreenItem.SimpleRow).value
        val lastName = (_screenItems[indexLastName] as ScreenItem.SimpleRow).value
        val email = (_screenItems[indexEmail] as ScreenItem.SimpleRow).value
        val isSignInEnable = firstName.trim().isNotBlank() &&
                lastName.trim().isNotBlank() &&
                emailValidator.isEmailValid(email = email)
        val updatedSignInButton =
            (_screenItems[indexSignInButton] as ScreenItem.LargeButton).copy(isEnable = isSignInEnable)
        _screenItems.removeAt(indexSignInButton)
        _screenItems.add(indexSignInButton, updatedSignInButton)
    }

    init {
        fillScreenItems()
    }
}