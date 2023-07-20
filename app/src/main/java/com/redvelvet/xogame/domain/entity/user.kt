package com.redvelvet.xogame.domain.entity


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
    val friends: List<FriendEntity>?,
    val friendRequest: List<FriendEntity>?,
    val friendRequestCount: Int?,
    val status: String?,
)

data class FriendEntity(
    val id: String?,
    val name: String?,
    val profilePictureUrl: String?,
    val email: String?,
    val friendsCount: Int?,
    val gamePlayed: Int?,
    val draw: Int?,
    val lost: Int?,
    val won: Int?,
    val friendRequestCount: Int?,
    val status: String?,
)