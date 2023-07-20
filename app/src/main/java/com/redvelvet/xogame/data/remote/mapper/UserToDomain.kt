package com.redvelvet.xogame.data.remote.mapper

import com.redvelvet.xogame.data.remote.dto.UserDto
import com.redvelvet.xogame.domain.entity.FriendEntity
import com.redvelvet.xogame.domain.entity.UserEntity

fun UserDto.toDomain(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
        profilePictureUrl = profilePictureUrl,
        friendRequest = friendRequest?.toDomain(),
        friends = friends?.toDomain(),
        friendRequestCount = friendRequestCount,
        friendsCount = friendsCount,
        gamePlayed = gamePlayed,
        draw = draw,
        lost = lost,
        won = won,
        status = status,
    )

fun List<UserDto>.toDomain() =
    map { friend ->
        FriendEntity(
            id = friend.id,
            name = friend.name,
            email = friend.email,
            profilePictureUrl = friend.profilePictureUrl,
            friendRequestCount = friend.friendRequestCount,
            friendsCount = friend.friendsCount,
            gamePlayed = friend.gamePlayed,
            draw = friend.draw,
            lost = friend.lost,
            won = friend.won,
            status = friend.status,
        )
    }