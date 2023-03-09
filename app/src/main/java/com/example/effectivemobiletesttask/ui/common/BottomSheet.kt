package com.example.effectivemobiletesttask.ui.common

import androidx.compose.material.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    quantity: Int,
    amount: String,
    content: @Composable () -> Unit,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit,
    onAddToCardCardClick: () -> Unit
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Expanded
        )
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            AddToCart(
                quantity = quantity,
                amount = amount,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
                onAddToCardCardClick = onAddToCardCardClick
            )
        }
    ) {
        content()
    }
}