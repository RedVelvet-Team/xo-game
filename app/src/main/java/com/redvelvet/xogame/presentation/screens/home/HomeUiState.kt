package com.redvelvet.xogame.presentation.screens.home


data class HomeUiState(
    val userUiState: UserUiState? = UserUiState(),
    val error: String? = null,
    val isLoading: Boolean = true,
)

data class UserUiState(
    val name: String? = null,
    val profilePictureUrl: String? = null,
    val friends: List<UserUiState>? = emptyList(),
    val onlineFriends: List<UserUiState>? = emptyList(),
)
