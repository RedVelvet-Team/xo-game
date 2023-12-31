package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GetIfUserIsLoggedInUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository,
) {
    suspend operator fun invoke(): Boolean =
        authGoogleRepository.checkIfUserIsLoggedIn()
}