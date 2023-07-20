package com.redvelvet.xogame.presentation.screens.home


data class HomeUiState(
    val userUiState: UserUiState? = UserUiState(),
    val error: String? = null,
    val isLoading: Boolean = true,
    val onlineFriends: List<UserUiState>? = emptyList(),
    val invited: Boolean? = false,
)

data class UserUiState(
    val id : String? = null,
    val name: String? = null,
    val profilePictureUrl: String? = null,
    val friends: List<UserUiState>? = emptyList(),
)
