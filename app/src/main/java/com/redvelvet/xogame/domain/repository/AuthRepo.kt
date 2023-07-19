package com.redvelvet.xogame.domain.repository


import com.redvelvet.xogame.app.util.Response


typealias SignUpResponse = Response<Boolean>
typealias LogInResponse = Response<Boolean>
typealias SignOutResponse = Response<Boolean>

interface AuthRepository {
    suspend fun firebaseSignUpAnonymously(): SignUpResponse
    suspend fun firebaseLogIn(): LogInResponse
    suspend fun firebaseSignOut(): SignOutResponse
    suspend fun checkIfUserIsLoggedIn(): Boolean

}