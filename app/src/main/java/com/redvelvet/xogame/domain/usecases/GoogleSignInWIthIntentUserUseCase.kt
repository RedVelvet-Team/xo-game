package com.redvelvet.xogame.domain.usecases

import android.content.Intent
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GoogleSignInWIthIntentUserUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
) {
    suspend fun invoke(intent: Intent) =
        authGoogleRepository.signInWithIntent(intent)
}