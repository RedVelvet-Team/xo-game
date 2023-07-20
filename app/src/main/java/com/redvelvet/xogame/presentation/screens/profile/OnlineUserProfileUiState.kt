package com.redvelvet.xogame.presentation.screens.profile

import com.redvelvet.xogame.data.util.ProfileStatus

data class OnlineUserProfileUiState(
    val imageUrl: String? = "",
    val status: String? = ProfileStatus.Offline,
    val profileName: String? = "",
    val gamesPlayed: Int? = 0,
    val gamesWon: Int? = 0,
    val gamesDraw: Int? = 0,
    val friendsNumber: Int? = 0,
    val sendFriendRequest:Boolean? = false
)
