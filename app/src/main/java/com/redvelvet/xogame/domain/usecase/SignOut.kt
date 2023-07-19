package com.redvelvet.xogame.domain.usecase
import com.redvelvet.xogame.domain.repository.AuthGoogleRepo

class SignOut(
    private val repo: AuthGoogleRepo
) {
    suspend operator fun invoke() = repo.firebaseSignOut()
}