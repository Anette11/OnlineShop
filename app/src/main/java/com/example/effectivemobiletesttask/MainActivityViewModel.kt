package com.example.effectivemobiletesttask

import androidx.lifecycle.ViewModel
import com.example.data.remote.DispatchersProvider
import com.example.domain.use_cases.GetUserByIsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getUserByIsLoggedInUseCase: GetUserByIsLoggedInUseCase,
    private val dispatchersProvider: DispatchersProvider
) : ViewModel() {

    fun checkIfUserIsLoggedIn(): Boolean = runBlocking(dispatchersProvider.io) {
        val loggedInUser = getUserByIsLoggedInUseCase.invoke(isLoggedIn = true)
        return@runBlocking loggedInUser != null
    }
}