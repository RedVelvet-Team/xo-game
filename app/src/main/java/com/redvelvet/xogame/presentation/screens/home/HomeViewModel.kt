package com.redvelvet.xogame.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.toObjects
import com.redvelvet.xogame.data.remote.dto.FriendDto
import com.redvelvet.xogame.data.remote.mapper.toDomain
import com.redvelvet.xogame.data.util.UserStatus
import com.redvelvet.xogame.domain.mapper.toDomain
import com.redvelvet.xogame.domain.mapper.toOnlineUsersDomain
import com.redvelvet.xogame.domain.usecases.CreateGameUseCase
import com.redvelvet.xogame.domain.usecases.DeclinedGameUseCase
import com.redvelvet.xogame.domain.usecases.GetInvitedGameUseCase
import com.redvelvet.xogame.domain.usecases.GetMyProfileUseCase
import com.redvelvet.xogame.domain.usecases.GetOnlineFriendsUseCase
import com.redvelvet.xogame.domain.usecases.SendInviteGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMyProfileUseCase: GetMyProfileUseCase,
    private val getOnlineFriendsUseCase: GetOnlineFriendsUseCase,
    private val getInvitedGameUseCase: GetInvitedGameUseCase,
    private val declinedGameUseCase: DeclinedGameUseCase,
    private val sendInviteGameUseCase: SendInviteGameUseCase,
    private val createGameUseCase: CreateGameUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMyProfile()
        streamInviteGame()
    }

    fun createGame(player1: String, player2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createGameUseCase.invoke(player1, player2)
        }
    }

    fun declineGame() {
        viewModelScope.launch(Dispatchers.IO) {
            declinedGameUseCase.invoke()
        }
    }

    fun sendInviteGame(id: String, name: String, image: String) {
        viewModelScope.launch(Dispatchers.IO) {
            sendInviteGameUseCase.invoke(id, name, image)
        }
    }

    private fun streamInviteGame() {
        viewModelScope.launch(Dispatchers.IO) {
            getInvitedGameUseCase.invoke().addSnapshotListener { v, e ->
                try {
                    val invite = v?.getBoolean("invited")
                    val name = v?.getString("name")
                    val image = v?.getString("image")
                    val id = v?.getString("id")
                    if (invite != null)
                        _state.update {
                            it.copy(
                                invited = invite,
                                invitePersonName = name,
                                invitePersonImage = image,
                                invitePersonId = id,
                            )
                        }
                } catch (e: Exception) {
                    throw e
                }
            }
        }
    }

    private fun getMyProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getMyProfileUseCase.invoke()
            getOnlineFriendsUseCase.invoke().addSnapshotListener { v, e ->
                try {
                    val online = v?.toObjects<FriendDto>()?.toDomain()
                        ?.filter { it.id != user.id && it.status != UserStatus.Offline }
                    if (online != null)
                        _state.update {
                            it.copy(
                                onlineFriends = online.toOnlineUsersDomain(),
                            )
                        }
                } catch (e: Exception) {
                    throw e
                }
            }
            _state.update {
                it.copy(
                    isLoading = false,
                    userUiState = user.toDomain(),
                )
            }
        }
    }
}