package com.example.effectivemobiletesttask.ui.screens.login_screens.signin

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import com.example.data.remote.DispatchersProvider
import com.example.domain.data.local.User
import com.example.domain.use_cases.GetUserByFirstNameUseCase
import com.example.domain.use_cases.SaveUserUseCase
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Graph
import com.example.effectivemobiletesttask.navigation.NavControllerType
import com.example.effectivemobiletesttask.navigation.NavigationAction
import com.example.effectivemobiletesttask.navigation.Screen
import com.example.effectivemobiletesttask.ui.screens.ClickAction
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider,
    private val emailValidator: EmailValidator,
    private val getUserByFirstNameUseCase: GetUserByFirstNameUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val mapKeysCreator: MapKeysCreator,
    private val dispatchersProvider: DispatchersProvider,
    private val clickActionTransmitter: ClickActionTransmitter,
    private val navigationActionTransmitter: NavigationActionTransmitter
) : ViewModel() {

    var screenItems = mutableStateListOf<ScreenItem>()
        private set

    var isLoading by mutableStateOf(false)
        private set

    private var indexFirstName = 0
    private var indexLastName = 0
    private var indexEmail = 0
    private var indexChangeColorText = 0
    private var indexSignInButton = 0

    private fun onSignIn() = launch(dispatchersProvider.io) {
        try {
            clickActionTransmitter.flow.emit(ClickAction.ClearFocus)
            onEmailChange(resourcesProvider.getString(R.string.empty))
            isLoading = true
            updateSignInEnable()
            val firstName = (screenItems[indexFirstName] as ScreenItem.SimpleRow).value
            val userExisting = getUserByFirstNameUseCase.invoke(firstName = firstName)
            if (userExisting != null) {
                isLoading = false
                updateSignInEnable()
                clickActionTransmitter.flow.emit(
                    ClickAction.ShowToast(
                        message = resourcesProvider.getString(
                            R.string.user_exists
                        )
                    )
                )
                return@launch
            }
            val email = (screenItems[indexEmail] as ScreenItem.SimpleRow).value
            val lastName = (screenItems[indexLastName] as ScreenItem.SimpleRow).value
            val password = resourcesProvider.getString(R.string.empty)
            val user = User(
                firstName = firstName,
                lastName = lastName,
                password = password,
                imageUri = null,
                isLoggedIn = true,
                email = email
            )
            saveUserUseCase.invoke(user = user)
            navigationActionTransmitter.flow.emit(
                NavigationAction.NavigateToScreen(
                    route = Graph.Main.route,
                    navControllerType = NavControllerType.Main
                )
            )
        } catch (e: Exception) {
            clickActionTransmitter.flow.emit(
                ClickAction.ShowToast(
                    message = resourcesProvider.getString(
                        R.string.user_save_error
                    )
                )
            )
        } finally {
            isLoading = false
            updateSignInEnable()
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
                    R.string.sign_in
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._60
                )
            ),
            mapKeysCreator.createMapKey().apply { indexFirstName = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.first_name),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexFirstName
                            )
                            updateSignInEnable()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._35
                )
            ),
            mapKeysCreator.createMapKey().apply { indexLastName = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.last_name),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexLastName
                            )
                            updateSignInEnable()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(R.integer._35)
            ),
            mapKeysCreator.createMapKey().apply { indexEmail = this } to
                    ScreenItem.SimpleRow(
                        placeholder = resourcesProvider.getString(R.string.email),
                        value = resourcesProvider.getString(R.string.empty),
                        onValueChange = { newValue ->
                            onValueChange(
                                newValue = newValue,
                                index = indexEmail
                            )
                            onEmailChange(newEmail = newValue)
                            updateSignInEnable()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    ),
            mapKeysCreator.createMapKey().apply { indexChangeColorText = this } to
                    ScreenItem.ChangeColorText(
                        textIsValid = resourcesProvider.getString(R.string.email_valid),
                        textNotValid = resourcesProvider.getString(R.string.email_not_valid),
                        isVisible = false,
                        isValid = false
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._35
                )
            ),
            mapKeysCreator.createMapKey().apply { indexSignInButton = this } to
                    ScreenItem.LargeButton(
                        text = resourcesProvider.getString(R.string.sign_in),
                        onClick = { onSignIn() },
                        isEnable = false
                    ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._15
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.InfoRow(
                textInfo = resourcesProvider.getString(R.string.already_have_an_account),
                textClickable = resourcesProvider.getString(R.string.log_in),
                onClick = {
                    launch(dispatchersProvider.io) {
                        navigationActionTransmitter.flow.emit(
                            NavigationAction.NavigateToScreen(
                                route = Screen.LogIn.route,
                                navControllerType = NavControllerType.Root
                            )
                        )
                    }
                }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._70
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextRow(
                icon = R.drawable.ic_google,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_google),
                text = resourcesProvider.getString(R.string.sign_in_with_google),
                onClick = {
                    launch(dispatchersProvider.io) {
                        clickActionTransmitter.flow.emit(ClickAction.GoogleSignIn)
                    }
                }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._38
                )
            ),
            mapKeysCreator.createMapKey() to ScreenItem.IconTextRow(
                icon = R.drawable.ic_apple,
                contentDescription = resourcesProvider.getString(R.string.sign_in_with_apple),
                text = resourcesProvider.getString(R.string.sign_in_with_apple),
                onClick = {
                    launch(dispatchersProvider.io) {
                        clickActionTransmitter.flow.emit(
                            ClickAction.ShowToast(
                                message = resourcesProvider.getString(
                                    R.string.sign_in_with_apple
                                )
                            )
                        )
                    }
                }
            ),
            mapKeysCreator.createMapKey() to ScreenItem.SpacerRow(
                height = resourcesProvider.getInteger(
                    R.integer._60
                )
            )
        )
        this.screenItems.addAll(screenItems.values)
    }

    private fun onValueChange(
        newValue: String,
        index: Int
    ) {
        screenItems[index] = (screenItems[index] as ScreenItem.SimpleRow).copy(value = newValue)
    }

    private fun onEmailChange(
        newEmail: String
    ) {
        val isEmailVisible = newEmail.isNotEmpty()
        val isEmailValid = emailValidator.isEmailValid(email = newEmail)
        screenItems[indexChangeColorText] =
            (screenItems[indexChangeColorText] as ScreenItem.ChangeColorText).copy(
                isVisible = isEmailVisible,
                isValid = isEmailValid
            )
    }

    private fun updateSignInEnable() {
        val firstName = (screenItems[indexFirstName] as ScreenItem.SimpleRow).value
        val lastName = (screenItems[indexLastName] as ScreenItem.SimpleRow).value
        val email = (screenItems[indexEmail] as ScreenItem.SimpleRow).value
        val isSignInEnable = firstName.trim().isNotBlank() &&
                lastName.trim().isNotBlank() &&
                emailValidator.isEmailValid(email = email) &&
                isLoading.not()
        screenItems[indexSignInButton] =
            (screenItems[indexSignInButton] as ScreenItem.LargeButton).copy(isEnable = isSignInEnable)
    }

    init {
        fillScreenItems()
    }
}