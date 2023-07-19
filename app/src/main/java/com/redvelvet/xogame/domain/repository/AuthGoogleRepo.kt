package com.redvelvet.xogame.domain.repository


import com.redvelvet.xogame.domain.model.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow


typealias AuthStateResponse = StateFlow<Boolean>
typealias SignInResponse = Response<Boolean>
typealias SignOut = Response<Boolean>

interface AuthGoogleRepo {
    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse

    suspend fun firebaseSignInAnonymously(): SignInResponse

    suspend fun firebaseSignOut(): SignOut
}