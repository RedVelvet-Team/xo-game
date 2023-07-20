package com.redvelvet.xogame.presentation.screens.profile.personal

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.xogame.presentation.screens.ProfileScreen

const val ROUTE = "personalProfile"

fun NavGraphBuilder.personalProfileRoute(navController: NavController) {
    composable(ROUTE) { ProfileScreen(navController) }
}