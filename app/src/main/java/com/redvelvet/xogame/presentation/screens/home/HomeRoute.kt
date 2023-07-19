package com.redvelvet.xogame.presentation.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.xogame.presentation.screens.HomeScreen

const val ROUTE = "home"

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(ROUTE){ HomeScreen(navController = navController)}
}