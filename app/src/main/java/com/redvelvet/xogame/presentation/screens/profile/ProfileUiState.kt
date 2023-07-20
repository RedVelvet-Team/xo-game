package com.redvelvet.xogame.presentation.screens.profile

import com.redvelvet.xogame.data.remote.dto.UserDto
import com.redvelvet.xogame.data.util.ProfileStatus
import com.redvelvet.xogame.presentation.util.FriendRequestState

data class ProfileUiState(
    val imageUrl: String? = "",
    val profileName: String? = "",
    val gamesPlayed: Int? = 0,
    val gamesWon: Int? = 0,
    val gamesDraw: Int? = 0,
    val friendsNumber: Int? = 0,
    val friendsRequest: List<Friends>? = emptyList(),
) {
    data class Friends(
        val id: String,
        val imageUrl: String? = "",
        val friendRequestName: String? = "",
        val friendState: String = ProfileStatus.Offline,
        val friendRequestState: FriendRequestState? = FriendRequestState.Waiting
    )
}
fun UserDto.toUiState():ProfileUiState.Friends{
    return ProfileUiState.Friends(
        id = id ?: "",
        imageUrl = profilePictureUrl ?: "",
        friendRequestName = name ?: "",
        friendState = status ?: "",
        friendRequestState = FriendRequestState.Waiting
    )

}
