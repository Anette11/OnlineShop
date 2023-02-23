package com.example.effectivemobiletesttask.ui.screens.signin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.*
import com.example.effectivemobiletesttask.ui.screens.items.ScreenItem

@Composable
fun SignInScreen(
    viewModel: SingInViewModel = hiltViewModel()
) = LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = dimensionResource(id = R.dimen._42dp))
) {
    items(items = viewModel.screenItems) { item ->
        when (item) {
            is ScreenItem.IconTextRow -> IconTextRow(
                icon = item.icon,
                contentDescription = item.contentDescription,
                text = item.text,
                onClick = item.onClick
            )
            is ScreenItem.InfoRow -> InfoRow(
                textInfo = item.textInfo,
                textClickable = item.textClickable,
                onClick = item.onClick
            )
            is ScreenItem.LargeButton -> LargeButton(
                text = item.text,
                onClick = item.onClick
            )
            is ScreenItem.LargeTitle -> LargeTitle(
                title = item.title
            )
            is ScreenItem.SimpleRow -> SimpleRow(
                placeholder = item.placeholder,
                value = item.value,
                onValueChange = item.onValueChange,
                showIcon = item.showIcon
            )
            is ScreenItem.SpacerRow -> SpacerRow(
                height = item.height
            )
        }
    }
}