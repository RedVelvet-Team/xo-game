package com.redvelvet.xogame.domain.mapper

import com.redvelvet.xogame.domain.entity.FriendEntity
import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.presentation.screens.home.UserUiState

fun UserEntity.toDomain() = UserUiState(
    name = name,
    profilePictureUrl = profilePictureUrl,
    friends = friends?.toDomain(),
    onlineFriends = friends?.toDomain()
)

fun List<FriendEntity>.toDomain() = map { friend ->
    UserUiState(
        name = friend.name,
        profilePictureUrl = friend.profilePictureUrl,
    )
}