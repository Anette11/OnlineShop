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
import com.example.effectivemobiletesttask.ui.common.MainContent
import com.example.effectivemobiletesttask.util.ClickActionTransmitter
import com.example.effectivemobiletesttask.util.NavigationActionTransmitter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var googleSignInActivityResultLauncher: ActivityResultLauncher<Intent>

    @Inject
    lateinit var clickActionTransmitter: ClickActionTransmitter

    @Inject
    lateinit var navigationActionTransmitter: NavigationActionTransmitter

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
            MainContent(
                clickActionTransmitter = clickActionTransmitter,
                navigationActionTransmitter = navigationActionTransmitter,
                onGoogleSignIn = { onGoogleSignIn() },
                onShareClick = { image -> onShareClick(image) },
                showToast = { message -> showToast(message) }
            )
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