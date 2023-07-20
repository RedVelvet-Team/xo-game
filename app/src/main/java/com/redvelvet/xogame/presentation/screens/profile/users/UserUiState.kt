package com.redvelvet.xogame.presentation.screens.profile.users

import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.presentation.screens.profile.personal.PersonalProfileUiState
import com.redvelvet.xogame.presentation.screens.profile.personal.toFriendRequestUiState

data class UserUiState(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val gamesPlayed: Int = 0,
    val gamesWon: Int = 0,
    val gamesDraw: Int = 0,
    val gamesLost: Int = 0,
    val friendsCount: Int = 0,
    val isFriend: Boolean = false
)

fun UserEntity.toUserUiState() = UserUiState(
    id = id ?: "",
    image = profilePictureUrl ?: "",
    name = name ?: "",
    friendsCount = friendsCount ?: 0,
    gamesDraw = draw ?: 0,
    gamesPlayed = gamePlayed ?: 0,
    gamesWon = won ?: 0,
    gamesLost = lost ?: 0,
)
