package com.nelson.ramirez.happytoday

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nelson.ramirez.happytoday.ui.AnotherScreen
import com.nelson.ramirez.happytoday.ui.HomeScreen
import com.nelson.ramirez.happytoday.ui.components.NavBar

@Composable
fun HappyTodayApp(navController: NavHostController) {

    //TODO injections
    val feelingsViewModel: FeelingsViewModel = viewModel(
        factory = FeelingsViewModel.provideFactory(
            repository = FeelingsRepository(FeelingsDataSource()),
        )
    )

    feelingsViewModel.loadFeelings(LocalContext.current)

    Scaffold(
        bottomBar = { NavBar(navController) }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(
                    state = feelingsViewModel.feelingsData,
                    showDialog = feelingsViewModel.showDialog,
                    intentHandler = feelingsViewModel::processIntent
                )
            }
            composable("another") {
                AnotherScreen()
            }
        }
    }

}