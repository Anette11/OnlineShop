package com.example.effectivemobiletesttask.ui.screens.login_screens.login

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import com.example.effectivemobiletesttask.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    resourcesProvider: ResourcesProvider
) : ViewModel() {

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.LargeTitle(title = resourcesProvider.getString(R.string.welcome_back)),
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.first_name),
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.SimpleRow(
            placeholder = resourcesProvider.getString(R.string.password),
            value = "",
            onValueChange = {},
            showIcon = true
        ),
        ScreenItem.SpacerRow(height = 100),
        ScreenItem.LargeButton(
            text = resourcesProvider.getString(R.string.login),
            onClick = {}
        )
    )
}