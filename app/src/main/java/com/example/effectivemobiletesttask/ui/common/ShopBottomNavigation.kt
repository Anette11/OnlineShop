package com.example.effectivemobiletesttask.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletesttask.R
import com.example.effectivemobiletesttask.navigation.Screen

@Composable
fun ShopBottomNavigation(
    items: List<Screen>,
    navController: NavHostController,
    onNavigateToScreen: (String) -> Unit
) = BottomNavigation(
    modifier = Modifier
//        .background(color = colorResource(id = R.color.white_dark))
        .fillMaxWidth()
        .clip(
            RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen._25dp),
                topEnd = dimensionResource(id = R.dimen._25dp)
            )
        ),
    backgroundColor = colorResource(id = R.color.white),
    contentColor = colorResource(id = R.color.gray_extra),
    elevation = AppBarDefaults.BottomAppBarElevation
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
        val isSelected = currentRoute?.contains(item.route) ?: false
        BottomNavigationItem(
            modifier = Modifier.padding(dimensionResource(id = R.dimen._12dp)),
            selected = isSelected,
            onClick = { onNavigateToScreen(item.route) },
            icon = {
                Box(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen._35dp))
                        .width(dimensionResource(id = R.dimen._35dp))
                        .clip(CircleShape)
                        .background(
                            color = if (isSelected) colorResource(id = R.color.gray_lighter)
                            else Color.Transparent
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(id = item.icon ?: R.drawable.ic_placeholder),
                        contentDescription = null
                    )
                }
            },
            alwaysShowLabel = false,
            selectedContentColor = colorResource(id = R.color.gray_blue),
            unselectedContentColor = colorResource(id = R.color.gray_extra)
        )
    }
}

@Composable
@Preview
fun ShopBottomNavigationPreview() =
    ShopBottomNavigation(
        items = listOf(
            Screen.Home,
            Screen.Favourite,
            Screen.Shopping,
            Screen.Chat,
            Screen.Profile
        ),
        navController = rememberNavController(),
        onNavigateToScreen = {}
    )