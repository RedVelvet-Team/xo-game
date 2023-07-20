package com.redvelvet.xogame.presentation.screens.profile.users

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.xogame.domain.usecases.GetFriendStatusUseCase
import com.redvelvet.xogame.domain.usecases.GetProfileByIdUseCase
import com.redvelvet.xogame.presentation.screens.profile.personal.toPersonalProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getProfileByIdUseCase: GetProfileByIdUseCase,
    private val getFriendStatusUseCase: GetFriendStatusUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(UserUiState())
    val state = _state.asStateFlow()
    private val args = UserProfileArgs(savedStateHandle)
    init {
        getUserProfileData()
    }

    private fun getUserProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            val profileData = getProfileByIdUseCase(args.destinationId).toPersonalProfileUiState()
            val friendStatus = getFriendStatusUseCase(args.destinationId,args.sourceId)
            _state.update {
                it.copy(
                    id = profileData.id,
                    name = profileData.name,
                    image = profileData.image,
                    friendsCount = profileData.friendsCount,
                    gamesWon = profileData.gamesWon,
                    gamesPlayed = profileData.gamesPlayed,
                    gamesDraw = profileData.gamesDraw,
                    gamesLost = profileData.gamesLost,
                    friendStatus = friendStatus
                )
            }
        }
    }

    fun makeFriendRequest(){

    }

    fun removeFriendRequest(){

    }

    fun acceptFriend(){

    }

    fun removeFriend(){

    }

}