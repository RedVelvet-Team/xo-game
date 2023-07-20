package com.redvelvet.xogame.presentation.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ROUTE = "home"

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(ROUTE){ HomeScreen(navController = navController)}
}