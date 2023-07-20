package com.redvelvet.xogame.app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.data.util.UserStatus
import com.redvelvet.xogame.domain.usecases.UpdateUserStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val updateUserStatusUseCase: UpdateUserStatusUseCase
) : ViewModel() {
    fun makeUserOnline() {
        viewModelScope.launch(Dispatchers.IO) {
            updateUserStatusUseCase.invoke(UserStatus.ONLINE)
        }
    }

    fun makeUserOffline() {
        viewModelScope.launch(Dispatchers.IO) {
            updateUserStatusUseCase.invoke(UserStatus.Offline)
        }
    }
}