package com.redvelvet.xogame.domain.repository


import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.redvelvet.xogame.app.util.Response
import com.redvelvet.xogame.domain.entity.SignInResult
import com.redvelvet.xogame.domain.entity.UserData


typealias SignUpResponse = Response<Boolean>
typealias LogInResponse = Response<Boolean>
typealias SignOutResponse = Response<Boolean>

interface AuthRepository {
    suspend fun firebaseSignUpAnonymously(): SignUpResponse
    suspend fun firebaseLogIn(): LogInResponse
    suspend fun firebaseSignOut(): SignOutResponse

    suspend fun signIn(): IntentSender?
    suspend fun signInWithIntent(intent: Intent): SignInResult
    suspend fun signOut()
    suspend fun getSignedInUser(): UserData?
    suspend fun buildSignInRequest(): BeginSignInRequest
}