package com.redvelvet.xogame.presentation.screens.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.xogame.presentation.screens.SplashScreen

private const val ROUTE = "Splash"

fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable(ROUTE) { SplashScreen(navController) }
}