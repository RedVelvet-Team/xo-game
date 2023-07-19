package com.redvelvet.xogame.presentation.screens.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.model.Response
import com.redvelvet.xogame.domain.repository.SignInResponse
import com.redvelvet.xogame.domain.repository.SignOut
import com.redvelvet.xogame.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    init {
        getAuthState()
    }

    var signInResponse by mutableStateOf<SignInResponse>(Response.Success(false))
        private set
    var signOutResponse by mutableStateOf<SignOut>(Response.Success(false))
        private set

    fun getAuthState() = useCases.getAuthState(viewModelScope)

    fun signIn() = viewModelScope.launch {
        signInResponse = Response.Loading
        signInResponse = useCases.signIn()
    }

    fun signOut() = viewModelScope.launch {
        signOutResponse = Response.Loading
        signOutResponse = useCases.signOut()
    }
}