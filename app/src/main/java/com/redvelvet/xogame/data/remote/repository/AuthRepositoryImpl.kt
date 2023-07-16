package com.redvelvet.xogame.data.remote.repository

import com.google.firebase.auth.FirebaseAuth
import com.redvelvet.xogame.app.util.Response
import com.redvelvet.xogame.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl  @Inject constructor(
    private val auth: FirebaseAuth
): AuthRepository {
    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)

    override suspend fun firebaseSignInAnonymously() = try {
        auth.signInAnonymously().await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun firebaseSignOut() = try {
        auth.currentUser?.delete()?.await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }
}