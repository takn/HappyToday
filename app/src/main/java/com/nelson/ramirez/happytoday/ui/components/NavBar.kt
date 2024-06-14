package com.nelson.ramirez.happytoday.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun NavBar(navController: NavHostController) {
    BottomAppBar {
        NavigationBarItem(
            selected = navController.currentDestination?.route == "home",
            onClick = { navController.navigate("home") },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "home",
                )
            })

        NavigationBarItem(
            selected = navController.currentDestination?.route == "another",
            onClick = { navController.navigate("another") },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.FavoriteBorder,
                    contentDescription = "favorite"
                )
            })

    }
}