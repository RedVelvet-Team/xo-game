package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import com.redvelvet.xogame.presentation.screens.profile.users.FriendStatus
import javax.inject.Inject

class GetFriendStatusUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
) {
    suspend operator fun invoke(firstUserId: String, secondUserId: String): FriendStatus =
        if (authGoogleRepository.getUserById(firstUserId)
                ?.friends?.find { it.id == secondUserId } != null
        ) {
            FriendStatus.FRIEND
        } else if (
            authGoogleRepository.getUserById(firstUserId)
                ?.friendRequest?.find { it.id == secondUserId } != null
        ) {
            FriendStatus.SENT_FRIEND_REQUEST
        } else if (
            authGoogleRepository.getUserById(secondUserId)
                ?.friendRequest?.find { it.id == firstUserId } != null
        ) {
            FriendStatus.RECEIVED_FRIEND_REQUEST
        }else{
            FriendStatus.NOT_FRIEND
        }


}
