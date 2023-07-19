package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthRepository
import com.redvelvet.xogame.domain.repository.SignUpResponse
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): SignUpResponse =
        authRepository.firebaseSignUpAnonymously()
}