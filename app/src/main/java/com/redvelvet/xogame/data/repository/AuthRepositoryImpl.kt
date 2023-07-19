package com.redvelvet.xogame.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.redvelvet.xogame.app.util.Response
import com.redvelvet.xogame.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val email: String,
    private val password: String,
) : AuthRepository {

    override suspend fun firebaseSignUpAnonymously() = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun firebaseLogIn() = try {
        auth.signInWithEmailAndPassword(email, password).await()
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

    override suspend fun checkIfUserIsLoggedIn(): Boolean =
        auth.currentUser != null
}
