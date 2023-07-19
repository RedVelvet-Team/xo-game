package com.redvelvet.xogame.presentation.screens.login

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetMyProfileUseCase
import com.redvelvet.xogame.domain.usecases.GoogleSignInUserUseCase
import com.redvelvet.xogame.domain.usecases.GoogleSignInWIthIntentUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoogleAuthViewModel @Inject constructor(
    private val googleSignInUserUseCase: GoogleSignInUserUseCase,
    private val googleSignInWIthIntentUserUseCase: GoogleSignInWIthIntentUserUseCase,
    private val getMyProfileUseCase: GetMyProfileUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(SignInUiState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: Result<Boolean>) {
        _state.update {
            it.copy(
                isSignInSuccessful = result.isSuccess,
                signInError = result.exceptionOrNull()?.message
            )
        }
    }

    fun signIn() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    intentSender = googleSignInUserUseCase.invoke()
                )
            }
            Log.i("KAMELOO",getMyProfileUseCase.invoke().toString())
        }
    }

    fun resetState() {
        _state.update { SignInUiState() }
    }

    suspend fun signInWithIntent(intent: Intent): Result<Boolean> {
        return googleSignInWIthIntentUserUseCase.invoke(intent)
    }
}