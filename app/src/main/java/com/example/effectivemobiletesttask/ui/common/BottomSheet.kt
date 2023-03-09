package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.effectivemobiletesttask.R

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
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white_dark)),
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            AddToCart(
                quantity = quantity,
                amount = amount,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
                onAddToCardCardClick = onAddToCardCardClick
            )
        },
        sheetShape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen._25dp),
            topEnd = dimensionResource(id = R.dimen._25dp)
        )
    ) {
        content()
    }
}