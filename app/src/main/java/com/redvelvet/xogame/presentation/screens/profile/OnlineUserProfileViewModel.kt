package com.redvelvet.xogame.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetProfileByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnlineUserProfileViewModel @Inject constructor(
    private val getProfileByIdUseCase: GetProfileByIdUseCase
): ViewModel() {
    private val _state = MutableStateFlow(OnlineUserProfileUiState())
    val state = _state.asStateFlow()
    init {
        fetchProfileData("")
    }
    private fun fetchProfileData(userId: String) {
        viewModelScope.launch {
            val myProfileData = getProfileByIdUseCase.invoke(userId)
            _state.update {
                it.copy(
                    profileName = myProfileData?.name,
                    imageUrl = myProfileData?.profilePictureUrl,
                    gamesWon = myProfileData?.won,
                    gamesDraw = myProfileData?.draw,
                    gamesPlayed = myProfileData?.gamePlayed,
                    friendsNumber = myProfileData?.friendsCount,
                    status = myProfileData?.status,
                )
            }
        }
    }
    private fun onClickInviteToPlay(){
    }
    private fun onClickSendFriendRequest(){
        _state.update { it.copy(sendFriendRequest = true) }
        //add friend to firebase friend list
    }
    private fun onClickRemove(){
        _state.update { it.copy(sendFriendRequest = false) }
        //remove friend from firebase friend list
    }
}