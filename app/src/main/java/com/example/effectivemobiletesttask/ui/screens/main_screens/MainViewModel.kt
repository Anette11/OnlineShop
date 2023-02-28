package com.example.effectivemobiletesttask.ui.screens.main_screens

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletesttask.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {
    val items = listOf(
        Screen.Home,
        Screen.Favourite,
        Screen.Shopping,
        Screen.Chat,
        Screen.Profile
    )
}