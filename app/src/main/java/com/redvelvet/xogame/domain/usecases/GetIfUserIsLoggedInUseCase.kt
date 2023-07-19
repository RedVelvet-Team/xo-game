package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import com.redvelvet.xogame.domain.repository.AuthRepository
import javax.inject.Inject

class GetIfUserIsLoggedInUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository,
    private val authRepository: AuthRepository
) {
    suspend fun invoke(): Boolean =
        authRepository.checkIfUserIsLoggedIn() || authGoogleRepository.checkIfUserIsLoggedIn()
}