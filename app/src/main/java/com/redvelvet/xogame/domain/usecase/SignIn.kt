package com.redvelvet.xogame.domain.usecase
import com.redvelvet.xogame.domain.repository.AuthGoogleRepo

class SignIn(
    private val repo: AuthGoogleRepo
) {
    suspend operator fun invoke() = repo.firebaseSignInAnonymously()
}