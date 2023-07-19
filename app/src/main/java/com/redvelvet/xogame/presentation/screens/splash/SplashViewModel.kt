package com.redvelvet.xogame.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetIfUserIsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getIfUserIsLoggedInUseCase: GetIfUserIsLoggedInUseCase
) : ViewModel() {
    private val _effect = MutableSharedFlow<SplashUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        checkIfUserLoggedIn()
    }

    private fun checkIfUserLoggedIn() {
        viewModelScope.launch {
            val isLoggedIn = getIfUserIsLoggedInUseCase()
            val uiEffect = if (isLoggedIn) {
                SplashUiEffect.GoToHomeUiEffect
            } else {
                SplashUiEffect.GoToSignUpUiEffect
            }
            _effect.emit(uiEffect)
        }
    }
}