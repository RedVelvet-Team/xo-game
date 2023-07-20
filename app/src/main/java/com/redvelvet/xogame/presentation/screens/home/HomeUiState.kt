package com.redvelvet.xogame.presentation.screens.home


data class HomeUiState(
    val userUiState: UserUiState? = UserUiState(),
    val error: String? = null,
    val isLoading: Boolean = true,
    val onlineFriends: List<UserUiState>? = emptyList(),
)

data class UserUiState(
    val name: String? = null,
    val profilePictureUrl: String? = null,
    val friends: List<UserUiState>? = emptyList(),
)
