package com.example.effectivemobiletesttask.ui.screens.items

data class AddToCartItem(
    val quantity: Int,
    val amountString: String,
    val amountDouble: Double,
    val price: Double,
    val onIncreaseClick: () -> Unit,
    val onDecreaseClick: () -> Unit,
    val onAddToCardCardClick: () -> Unit
)