package com.redvelvet.xogame.presentation.screens.profile.personal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetMyProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonalProfileViewModel @Inject constructor(
    private val getMyProfileUseCase: GetMyProfileUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(PersonalProfileUiState())
    val state = _state.asStateFlow()

    init {
        getPersonalProfileData()
    }

    private fun getPersonalProfileData() {
        viewModelScope.launch {
            val profileData = getMyProfileUseCase().toPersonalProfileUiState()
            _state.update {
                it.copy(
                    id = profileData.id,
                    name = profileData.name,
                    image = profileData.image,
                    friendsCount = profileData.friendsCount,
                    gamesWon = profileData.gamesWon,
                    gamesPlayed = profileData.gamesPlayed,
                    gamesDraw = profileData.gamesDraw,
                    friendRequests = profileData.friendRequests
                )
            }
        }
    }
}