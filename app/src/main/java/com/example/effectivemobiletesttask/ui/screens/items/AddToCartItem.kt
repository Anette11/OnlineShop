package com.example.effectivemobiletesttask.ui.screens.items

data class AddToCartItem(
    val amountString: String,
    val amountDouble: Double,
    val onIncreaseClick: () -> Unit,
    val onDecreaseClick: () -> Unit,
    val onAddToCardCardClick: () -> Unit
)