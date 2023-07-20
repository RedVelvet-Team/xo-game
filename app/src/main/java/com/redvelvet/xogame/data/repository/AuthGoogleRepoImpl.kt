package com.redvelvet.xogame.data.repository

import android.content.Intent
import android.content.IntentSender
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.redvelvet.xogame.data.remote.dto.UserDto
import com.redvelvet.xogame.data.remote.mapper.toDomain
import com.redvelvet.xogame.data.util.ProfileStatus
import com.redvelvet.xogame.domain.entity.UserEntity
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthGoogleRepoImpl @Inject constructor(
    private val webClientId: String,
    private val oneTapClient: SignInClient,
    private val auth: FirebaseAuth,
    private val databaseFireStore: FirebaseFirestore,
) : AuthGoogleRepository {

    override suspend fun signIn(): IntentSender? {
        val result = try {
            oneTapClient.beginSignIn(
                buildSignInRequest()
            ).await()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            throw e
        }
        return result?.pendingIntent?.intentSender
    }

    override suspend fun signInWithIntent(intent: Intent): Result<Boolean> {
        val credential = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = credential.googleIdToken
        val googleCredentials = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCredentials).await().user
            if (!(databaseFireStore.collection(USERS).document(user?.uid.toString()).get().await()
                    .exists())
            )
                databaseFireStore.collection(USERS).document(user?.uid.toString())
                    .set(
                        UserDto(
                            id = user?.uid.toString(),
                            name = user?.displayName,
                            profilePictureUrl = user?.photoUrl?.toString(),
                            email = user?.email,
                            phoneNumber = user?.phoneNumber,
                            friends = listOf(
                                UserDto(
                                    id = user?.uid.toString(),
                                    name = user?.displayName,
                                    profilePictureUrl = user?.photoUrl?.toString(),
                                    email = user?.email,
                                    phoneNumber = user?.phoneNumber,
                                ),
                            )
                        )
                    ).await()
            Result.success(true)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure<Exception>(e)
            throw e
        }
    }

    override suspend fun signOut() {
        try {
            oneTapClient.signOut().await()
            auth.signOut()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            throw e
        }
    }

    override suspend fun getSignedInUser(): UserEntity? = getProfileById(auth.uid.toString())

    private suspend fun getProfileById(userId: String): UserEntity? {
        return try {
            databaseFireStore.collection(USERS)
                .document(userId)
                .get()
                .await().toObject<UserDto>()?.toDomain()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getUserById(userId: String): UserEntity? {
        return getProfileById(userId)
    }

    private fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(webClientId)
                    .build()
            ).setAutoSelectEnabled(true)
            .build()
    }

    override suspend fun checkIfUserIsLoggedIn(): Boolean {
        return getSignedInUser() != null
    }

    override suspend fun updateUserStatue(status: ProfileStatus) {
        databaseFireStore.collection(USERS)
            .document(auth.uid.toString())
            .update(STATUS, status)
            .await()
    }

    companion object {
        private const val USERS = "Users"
        private const val STATUS = "status"
    }
}

