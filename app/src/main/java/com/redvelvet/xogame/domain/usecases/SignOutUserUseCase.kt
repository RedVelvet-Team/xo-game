package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthRepository
import com.redvelvet.xogame.domain.repository.SignOutResponse
import javax.inject.Inject

class SignOutUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): SignOutResponse =
        authRepository.firebaseSignOut()
}