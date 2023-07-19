package com.redvelvet.xogame.data.remote.mapper

import com.redvelvet.xogame.data.remote.dto.UserDto
import com.redvelvet.xogame.domain.entity.UserEntity

fun UserDto.toDomain(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        email = email,
        profilePictureUrl = profilePictureUrl,
        friendRequest = friendRequest,
        friends = friends,
        friendRequestCount = friendRequestCount,
        friendsCount = friendsCount,
        gamePlayed = gamePlayed,
        draw = draw,
        lost = lost,
        won = won,
    )