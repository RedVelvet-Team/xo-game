package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GetProfileByIdUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
) {
    suspend fun invoke(userId: String) =
        authGoogleRepository.getUserById(userId)
}