package com.redvelvet.xogame.app.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redvelvet.xogame.presentation.screens.gameBoard.GameBoardScreen
import com.redvelvet.xogame.presentation.screens.home.homeRoute
import com.redvelvet.xogame.presentation.screens.profile.personal.personalProfileRoute
import com.redvelvet.xogame.presentation.screens.profile.users.userProfileRoute

@Composable
fun XoNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "game") {
        homeRoute(navController)
        personalProfileRoute(navController)
        userProfileRoute(navController)
        composable("game") { GameBoardScreen() }
    }
}