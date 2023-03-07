package com.example.effectivemobiletesttask.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

fun ViewModel.launch(
    coroutineDispatcher: CoroutineDispatcher,
    function: suspend () -> Unit
) = viewModelScope.launch(coroutineDispatcher) {
    function()
}