package com.redvelvet.xogame.data.remote.repository

import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.redvelvet.xogame.domain.entity.SignInResult
import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthGoogleRepoImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val webClientId: String,
    private val oneTapClient: SignInClient
) : AuthGoogleRepository {
    override suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }
        return result?.pendingIntent?.intentSender
    }

    override suspend fun signInWithIntent(intent: Intent): SignInResult {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            SignInResult(
                data = user?.run {
                    UserEntity(
                        userId = uid,
                        username = displayName,
                        profilePictureUrl = photoUrl?.toString(),
                        email = email,
                    )
                },
                errorMessage = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignInResult(
                data = null,
                errorMessage = e.message
            )
        }
    }

    override suspend fun signOut() {
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
        }
    }

    override suspend fun getSignedInUser(): UserEntity? = auth.currentUser?.run {
        UserEntity(
            userId = uid,
            username = displayName,
            profilePictureUrl = photoUrl?.toString(),
            email = email,
        )
    }

    override suspend fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(webClientId)
                    .build()
            )
            .setAutoSelectEnabled(true)
            .build()
    }
}