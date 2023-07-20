package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GetMyProfileUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
) {
    suspend operator fun invoke() =
        authGoogleRepository.getSignedInUser() ?: UserEntity(
            id = "",
            name = "",
            profilePictureUrl = "",
            friends = emptyList(),
            draw = 0,
            email = "",
            friendsCount = 0,
            lost = 0,
            gamePlayed = 0,
            status = "",
            won = 0,
            friendRequest = emptyList(),
            friendRequestCount = 0
        )
}