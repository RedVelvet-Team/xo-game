package com.redvelvet.xogame.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetMyProfileUseCase
import com.redvelvet.xogame.presentation.util.FriendRequestState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getMyProfileUseCase: GetMyProfileUseCase
): ViewModel() {
    private val _state = MutableStateFlow(ProfileUiState())
    val state = _state.asStateFlow()
    init {
        fetchProfileData()
    }
    private fun fetchProfileData() {
        viewModelScope.launch {
            val myProfileData = getMyProfileUseCase.invoke()
            _state.update {
                it.copy(
                    profileName = myProfileData?.name,
                    imageUrl = myProfileData?.profilePictureUrl,
                    gamesWon = myProfileData?.won,
                    gamesDraw = myProfileData?.draw,
                    gamesPlayed = myProfileData?.gamePlayed,
                    friendsNumber = myProfileData?.friendsCount,
                    friendsRequest = myProfileData?.friendRequest?.map {userDto -> userDto.toUiState()})
            }
        }
    }
    private fun updateFriendRequest(friendRequestState: FriendRequestState){
        _state.update { it.copy() }
    }
}