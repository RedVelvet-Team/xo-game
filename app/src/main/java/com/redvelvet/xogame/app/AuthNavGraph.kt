package com.redvelvet.xogame.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AuthNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "SignUp") {

    }
}