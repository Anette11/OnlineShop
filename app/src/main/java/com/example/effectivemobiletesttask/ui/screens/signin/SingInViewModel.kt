package com.example.effectivemobiletesttask.ui.screens.signin

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(

) : ViewModel() {

    val screenItems = listOf(
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.LargeTitle(title = "Sign in"),
        ScreenItem.SpacerRow(height = 60),
        ScreenItem.SimpleRow(
            placeholder = "First name",
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.SimpleRow(
            placeholder = "Last name",
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.SimpleRow(
            placeholder = "Email",
            value = "",
            onValueChange = {},
            showIcon = false
        ),
        ScreenItem.SpacerRow(height = 35),
        ScreenItem.LargeButton(
            text = "Sign in",
            onClick = {}
        ),
        ScreenItem.SpacerRow(height = 15),
        ScreenItem.InfoRow(
            textInfo = "Already have an account?",
            textClickable = "Log in",
            onClick = {}
        ),
        ScreenItem.SpacerRow(height = 70),
        ScreenItem.IconTextRow(
            icon = R.drawable.ic_g,
            contentDescription = "Sign in with Google",
            text = "Sign in with Google"
        ),
        ScreenItem.SpacerRow(height = 38),
        ScreenItem.IconTextRow(
            icon = R.drawable.ic_a,
            contentDescription = "Sign in with Apple",
            text = "Sign in with Apple"
        ),
        ScreenItem.SpacerRow(height = 60)
    )
}