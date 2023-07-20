package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dountapplication.screen.VerticalSpacer
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.OneFriendRequestCard
import com.redvelvet.xogame.presentation.composable.ProfileAppbar
import com.redvelvet.xogame.presentation.composable.ProfileCard
import com.redvelvet.xogame.presentation.screens.profile.ProfileUiState
import com.redvelvet.xogame.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ProfileContent(state = state)
}

@Composable
fun ProfileContent(state: ProfileUiState) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = "background"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            VerticalSpacer(space = 48)
            ProfileAppbar()
            VerticalSpacer(space = 56)
            ProfileCard(
                imageUrl = state.imageUrl ?: "",
                profileName = state.profileName ?: "",
                gamesPlayedValue = state.gamesPlayed ?: 0,
                gamesWon = state.gamesWon ?: 0,
                gamesDraw = state.gamesDraw ?: 0,
                friendsValue = state.friendsNumber ?: 0,
            )
            VerticalSpacer(space = 32)
            LazyColumn(
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
            ) {
                items(count = state.friendsRequest?.size ?: 0) {
                    OneFriendRequestCard(
                        state.friendsRequest?.get(it)?.imageUrl,
                        state.friendsRequest?.get(it)?.friendRequestName
                    )
                }
            }
        }

    }

}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileContent(){
    ProfileScreen()
}