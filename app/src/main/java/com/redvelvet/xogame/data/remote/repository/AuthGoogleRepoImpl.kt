package com.redvelvet.xogame.data.remote.repository

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.util.Log
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.redvelvet.xogame.R
import com.redvelvet.xogame.domain.entity.SignInResult
import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthGoogleRepoImpl @Inject constructor(
    private val context: Context,
    private val oneTapClient: SignInClient
) : AuthGoogleRepository {
    private val auth = Firebase.auth
    private val db = Firebase.firestore
    override suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("KAMELOO", e.message.toString())
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
            db.collection("Users").document(user?.uid.toString())
                .set(
                    UserEntity(
                        userId = user?.uid.toString(),
                        username = user?.displayName,
                        profilePictureUrl = user?.photoUrl?.toString(),
                        email = user?.email,
                    )
                ).await()
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
            Log.e("KAMELOO", e.message.toString())
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
            Log.e("KAMELOO", e.message.toString())
            if (e is CancellationException) throw e
        }
    }

    override fun getSignedInUser(): UserEntity? = auth.currentUser?.run {
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
                    .setServerClientId(context.getString(R.string.web_cliend_id))
                    .build()
            ).setAutoSelectEnabled(true)
            .build()
    }
}

