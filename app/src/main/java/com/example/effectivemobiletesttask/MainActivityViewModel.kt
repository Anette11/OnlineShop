package com.example.effectivemobiletesttask

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.GetUserByIsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getUserByIsLoggedInUseCase: GetUserByIsLoggedInUseCase
) : ViewModel() {

    fun checkIfUserIsLoggedIn(): Boolean = runBlocking(Dispatchers.IO) {
        val loggedInUser = getUserByIsLoggedInUseCase.invoke(isLoggedIn = true)
        return@runBlocking loggedInUser != null
    }
}