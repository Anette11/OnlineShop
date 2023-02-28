package com.example.effectivemobiletesttask

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.effectivemobiletesttask.navigation.RootNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContent {
            RootNavGraph(
                onShowToast = { message ->
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}