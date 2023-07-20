package com.redvelvet.xogame.data.remote.dto

import com.redvelvet.xogame.data.util.ProfileStatus

data class FriendDto(
    val id: String? = null,
    val name: String? = null,
    val email: String? = null,
    val profilePictureUrl: String? = null,
    val phoneNumber: String? = null,
    val friendsCount: Int? = 0,
    val gamePlayed: Int? = 0,
    val draw: Int? = 0,
    val lost: Int? = 0,
    val won: Int? = 0,
    val friendRequestCount: Int? = 0,
    val status: String? = ProfileStatus.Offline,
)