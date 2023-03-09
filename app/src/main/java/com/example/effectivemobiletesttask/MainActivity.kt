package com.example.effectivemobiletesttask

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.navigation.Graph
import com.example.effectivemobiletesttask.navigation.RootNavGraph
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var googleSignInActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        googleSignInActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { activityResult ->
            when (activityResult.resultCode == Activity.RESULT_OK) {
                true -> showToast(message = getString(R.string.google_sign_in_success))
                false -> showToast(message = getString(R.string.google_sign_in_fail))
            }
        }

        setContent {
            val viewModel: MainActivityViewModel = hiltViewModel()
            val focusManager = LocalFocusManager.current
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.white_dark))
            ) {
                RootNavGraph(
                    onShowToast = { message -> showToast(message = message) },
                    onClearFocus = { focusManager.clearFocus() },
                    startDestination = if (viewModel.checkIfUserIsLoggedIn()) Graph.Main.route
                    else Graph.Login.route,
                    onShareClick = { image -> onShareClick(image = image) },
                    onGoogleSignIn = { onGoogleSignIn() }
                )
            }
        }
    }

    private fun onGoogleSignIn() {
        val googleSignInOptions = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        val signInIntent = googleSignInClient.signInIntent
        googleSignInActivityResultLauncher.launch(signInIntent)
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