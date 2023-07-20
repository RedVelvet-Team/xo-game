package com.redvelvet.xogame.app.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.xogame.presentation.screens.home.homeRoute
import com.redvelvet.xogame.presentation.screens.profile.personal.personalProfileRoute
import com.redvelvet.xogame.presentation.screens.profile.users.userProfileRoute

@Composable
fun XoNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "personalProfile") {
        homeRoute(navController)
        personalProfileRoute(navController)
        userProfileRoute(navController)
    }
}