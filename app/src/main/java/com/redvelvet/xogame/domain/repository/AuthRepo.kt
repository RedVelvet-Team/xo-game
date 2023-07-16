package com.redvelvet.xogame.domain.repository


import com.redvelvet.xogame.app.util.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow


typealias AuthStateResponse = StateFlow<Boolean>
typealias SignInResponse = Response<Boolean>
typealias SignOutResponse = Response<Boolean>

interface AuthRepository {
    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse

    suspend fun firebaseSignInAnonymously(): SignInResponse

    suspend fun firebaseSignOut(): SignOutResponse
}