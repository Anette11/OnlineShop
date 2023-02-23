package com.example.effectivemobiletesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.effectivemobiletesttask.navigation.ShopNavHost
import com.example.effectivemobiletesttask.ui.theme.EffectiveMobileTestTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveMobileTestTaskTheme {
                ShopNavHost()
            }
        }
    }
}