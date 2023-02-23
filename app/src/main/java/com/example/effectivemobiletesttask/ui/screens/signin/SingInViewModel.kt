package com.example.effectivemobiletesttask.ui.screens.signin

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

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
            onClick = {}
        ),
        ScreenItem.SpacerRow(height = 15),
        ScreenItem.InfoRow(
            textInfo = resourcesProvider.getString(R.string.already_have_an_account),
            textClickable = resourcesProvider.getString(R.string.log_in),
            onClick = {}
        ),
        ScreenItem.SpacerRow(height = 70),
        ScreenItem.IconTextRow(
            icon = R.drawable.ic_google,
            contentDescription = resourcesProvider.getString(R.string.sign_in_with_google),
            text = resourcesProvider.getString(R.string.sign_in_with_google)
        ),
        ScreenItem.SpacerRow(height = 38),
        ScreenItem.IconTextRow(
            icon = R.drawable.ic_apple,
            contentDescription = resourcesProvider.getString(R.string.sign_in_with_apple),
            text = resourcesProvider.getString(R.string.sign_in_with_apple)
        ),
        ScreenItem.SpacerRow(height = 60)
    )
}