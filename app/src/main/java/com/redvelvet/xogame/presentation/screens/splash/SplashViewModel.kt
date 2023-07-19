package com.redvelvet.xogame.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetIfUserIsLoggedInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getIfUserIsLoggedInUseCase: GetIfUserIsLoggedInUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SplashScreenUiState())
    val state = _state.asStateFlow()

    init {
        checkIfUserLoggedIn()
    }

    private fun checkIfUserLoggedIn() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    isLogged = getIfUserIsLoggedInUseCase()
                )
            }
        }
    }
}