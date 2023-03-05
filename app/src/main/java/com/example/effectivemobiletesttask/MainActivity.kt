package com.example.effectivemobiletesttask

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.navigation.Graph
import com.example.effectivemobiletesttask.navigation.RootNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: MainActivityViewModel = hiltViewModel()
            val focusManager = LocalFocusManager.current

            RootNavGraph(
                onShowToast = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                },
                onClearFocus = { focusManager.clearFocus() },
                startDestination = if (viewModel.checkIfUserIsLoggedIn()) Graph.Main.route
                else Graph.Login.route
            )
        }
    }
}