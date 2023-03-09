package com.example.effectivemobiletesttask

import android.content.ActivityNotFoundException
import android.content.Intent
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
                onShowToast = { message -> showToast(message = message) },
                onClearFocus = { focusManager.clearFocus() },
                startDestination = if (viewModel.checkIfUserIsLoggedIn()) Graph.Main.route
                else Graph.Login.route,
                onShareClick = { image -> onShareClick(image = image) }
            )
        }
    }

    private fun onShareClick(
        image: String
    ) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = getString(R.string.text_plain_type)
            putExtra(Intent.EXTRA_TEXT, image)
            putExtra(Intent.EXTRA_TITLE, getString(R.string.share_intent_extra_title))
        }
        val intentChooser = Intent.createChooser(
            shareIntent,
            getString(R.string.share_intent_chooser_title)
        )
        try {
            startActivity(intentChooser)
        } catch (e: ActivityNotFoundException) {
            showToast(message = getString(R.string.no_activity_found_message))
        }
    }

    private fun showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}