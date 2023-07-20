package com.redvelvet.xogame.presentation.screens.profile.users

import com.redvelvet.xogame.domain.entity.UserEntity

data class UserUiState(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val gamesPlayed: Int = 0,
    val gamesWon: Int = 0,
    val gamesDraw: Int = 0,
    val gamesLost: Int = 0,
    val friendsCount: Int = 0,
    val friendStatus: FriendStatus = FriendStatus.NOT_FRIEND
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

enum class FriendStatus {
    FRIEND,
    NOT_FRIEND,
    SENT_FRIEND_REQUEST,
    RECEIVED_FRIEND_REQUEST
}
