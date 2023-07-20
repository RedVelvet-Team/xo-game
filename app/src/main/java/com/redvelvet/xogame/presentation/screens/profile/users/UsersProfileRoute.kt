package com.redvelvet.xogame.presentation.screens.profile.users

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.xogame.presentation.screens.UserProfileScreen

const val ROUTE = "userProfile"
fun NavController.navigateToUserProfile(sourceUserID: String, destinationUserId: String) {
    navigate("ROUTE/${destinationUserId}/${sourceUserID}")
}

fun NavGraphBuilder.userProfileRoute(navController: NavController) {
    composable(
        "$ROUTE/{${UserProfileArgs.DESTINATION_USER_ID}}/{${UserProfileArgs.SOURCE_USER_ID}}",
        arguments = listOf(
            navArgument(UserProfileArgs.DESTINATION_USER_ID) { NavType.StringType },
            navArgument(UserProfileArgs.SOURCE_USER_ID) { NavType.StringType }
        )
    ) {
        UserProfileScreen(navController)
    }
}

class UserProfileArgs(savedStateHandle: SavedStateHandle) {
    val destinationId: String = requireNotNull(savedStateHandle[DESTINATION_USER_ID])
    val sourceId: String = requireNotNull(savedStateHandle[SOURCE_USER_ID])

    companion object {
        const val DESTINATION_USER_ID = "destinationId"
        const val SOURCE_USER_ID = "sourceId"
    }
}