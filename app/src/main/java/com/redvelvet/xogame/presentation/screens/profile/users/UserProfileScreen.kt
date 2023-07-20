package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dountapplication.screen.VerticalSpacer
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.ProfileAppbar
import com.redvelvet.xogame.presentation.composable.ProfileButton
import com.redvelvet.xogame.presentation.composable.ProfileCard
import com.redvelvet.xogame.presentation.screens.profile.users.FriendStatus
import com.redvelvet.xogame.presentation.screens.profile.users.UserProfileViewModel
import com.redvelvet.xogame.presentation.screens.profile.users.UserUiState

@Composable
fun UserProfileScreen(
    navController: NavController,
    viewModel: UserProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val onClick: () -> Unit = when (state.friendStatus) {
        FriendStatus.FRIEND -> {
            viewModel::removeFriend
        }

        FriendStatus.RECEIVED_FRIEND_REQUEST -> {
            viewModel::acceptFriend
        }

        FriendStatus.SENT_FRIEND_REQUEST -> {
            viewModel::removeFriendRequest
        }

        else -> {
            viewModel::acceptFriend
        }
    }
    UserProfileContent(state = state, { navController.popBackStack() }) { onClick() }
}

@Composable
fun UserProfileContent(
    state: UserUiState,
    onClickBack: () -> Boolean,
    onClickSecondButton: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = stringResource(id = R.string.background)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            VerticalSpacer(space = 48)
            ProfileAppbar(onClickBack)
            VerticalSpacer(space = 56)
            ProfileCard(
                state.image,
                state.name,
                state.gamesPlayed,
                state.gamesWon,
                state.gamesDraw,
                state.gamesLost,
                state.friendsCount
            )
            VerticalSpacer(space = 32)
            ProfileButton(text = stringResource(R.string.invite_to_play))
            VerticalSpacer(space = 12)
            val text =
                when (state.friendStatus) {
                    FriendStatus.FRIEND -> stringResource(R.string.remove_friend)
                    FriendStatus.RECEIVED_FRIEND_REQUEST -> stringResource(R.string.accept_friend_request)
                    FriendStatus.SENT_FRIEND_REQUEST -> stringResource(R.string.remove_friend_request)
                    else -> stringResource(R.string.send_a_friend_request)
                }
            ProfileButton(text = text)
        }
    }
}