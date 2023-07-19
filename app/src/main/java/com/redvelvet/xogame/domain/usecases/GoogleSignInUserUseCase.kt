package com.redvelvet.xogame.domain.usecases

import android.content.IntentSender
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GoogleSignInUserUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
) {
    suspend fun invoke(): IntentSender =
        authGoogleRepository.signIn()
}