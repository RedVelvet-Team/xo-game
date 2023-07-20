package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.data.util.UserStatus
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class UpdateUserStatusUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository,
) {
    suspend operator fun invoke(status: String) =
        authGoogleRepository.updateUserStatue(status)
}