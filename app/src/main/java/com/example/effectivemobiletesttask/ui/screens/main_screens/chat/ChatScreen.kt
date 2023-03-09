package com.example.effectivemobiletesttask.ui.screens.main_screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.ui.common.LargeTitle

@Composable
fun ChatScreen() =
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white_dark)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LargeTitle(title = stringResource(id = R.string.chat))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen._16dp)))
        Icon(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = stringResource(id = R.string.cart),
            modifier = Modifier.size(dimensionResource(id = R.dimen._52dp)),
            tint = colorResource(id = R.color.gray_extra)
        )
    }