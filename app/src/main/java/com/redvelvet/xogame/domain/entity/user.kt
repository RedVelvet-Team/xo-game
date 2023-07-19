package com.redvelvet.xogame.domain.entity

import com.redvelvet.xogame.data.remote.dto.UserDto


data class UserEntity(
    val id: String?,
    val name: String?,
    val profilePictureUrl: String?,
    val email: String?,
    val friendsCount: Int?,
    val gamePlayed: Int?,
    val draw: Int?,
    val lost: Int?,
    val won: Int?,
    val friends: List<UserDto>?,
    val friendRequest: List<UserDto>?,
    val friendRequestCount: Int?,
    val status: String?,
)