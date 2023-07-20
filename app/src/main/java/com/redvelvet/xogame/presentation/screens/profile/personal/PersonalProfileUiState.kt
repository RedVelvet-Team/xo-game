package com.redvelvet.xogame.presentation.screens.profile.personal

import com.redvelvet.xogame.domain.entity.FriendEntity
import com.redvelvet.xogame.domain.entity.UserEntity

data class PersonalProfileUiState(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val gamesPlayed: Int = 0,
    val gamesWon: Int = 0,
    val gamesDraw: Int = 0,
    val friendsCount: Int = 0,
    val friendRequests: List<FriendRequestUiState> = emptyList()
)

data class FriendRequestUiState(
    val id: String = "",
    val name: String = "",
    val image: String = ""
)

fun UserEntity.toPersonalProfileUiState() = PersonalProfileUiState(
    id = id ?: "",
    image = profilePictureUrl ?: "",
    name = name ?: "",
    friendRequests = friendRequest?.map { it.toFriendRequestUiState() } ?: emptyList(),
    friendsCount = friendsCount ?: 0,
    gamesDraw = draw ?: 0,
    gamesPlayed = gamePlayed ?: 0,
    gamesWon = won ?: 0
)

fun FriendEntity.toFriendRequestUiState() = FriendRequestUiState(
    id = id ?: "",
    name = name ?: "",
    image = profilePictureUrl ?: ""
)