package com.redvelvet.xogame.presentation.screens.profile.users

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.xogame.presentation.screens.UserProfileScreen

const val ROUTE = "userProfile"
fun NavController.navigateToUserProfile(id: String) {
    navigate("ROUTE/${id}")
}

fun NavGraphBuilder.userProfileRoute(navController: NavController) {
    composable(
        "$ROUTE/{${UserProfileArgs.ID_ARG}}",
        arguments = listOf(navArgument(UserProfileArgs.ID_ARG) { NavType.StringType })
    ) {
        UserProfileScreen(navController)
    }
}

class UserProfileArgs(savedStateHandle: SavedStateHandle) {
    val id: String = requireNotNull(savedStateHandle[ID_ARG])

    companion object {
        const val ID_ARG = "id"
    }
}