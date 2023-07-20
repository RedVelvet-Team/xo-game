package com.redvelvet.xogame.presentation.screens.gameBoard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ROUTE = "game"

fun NavGraphBuilder.gameBoardRoute(navController: NavController) {
    composable(ROUTE) { GameBoardScreen(navController) }
}

fun NavController.navigateToGameBoard() {
    navigate(ROUTE)
}