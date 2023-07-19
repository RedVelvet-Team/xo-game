package com.redvelvet.xogame.domain.repository

import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.redvelvet.xogame.domain.entity.SignInResult
import com.redvelvet.xogame.domain.entity.UserEntity

interface AuthGoogleRepository {
    suspend fun signIn(): IntentSender?

    suspend fun signInWithIntent(intent: Intent): SignInResult

    suspend fun signOut()

    fun getSignedInUser(): UserEntity?

    suspend fun buildSignInRequest(): BeginSignInRequest

    suspend fun checkIfUserIsLoggedIn(): Boolean
}