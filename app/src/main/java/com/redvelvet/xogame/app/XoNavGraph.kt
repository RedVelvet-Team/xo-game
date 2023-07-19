package com.redvelvet.xogame.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.xogame.presentation.screens.home.homeRoute

@Composable
fun XoNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        homeRoute(navController)
    }
}