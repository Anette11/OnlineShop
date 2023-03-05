package com.example.effectivemobiletesttask.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.launch(function: suspend () -> Unit) =
    viewModelScope.launch(Dispatchers.IO) { function() }