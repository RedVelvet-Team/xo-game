package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.dountapplication.screen.VerticalSpacer
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.OneFriendRequestCard
import com.redvelvet.xogame.presentation.composable.ProfileAppbar
import com.redvelvet.xogame.presentation.composable.ProfileCard
import com.redvelvet.xogame.presentation.screens.profile.personal.PersonalProfileUiState
import com.redvelvet.xogame.presentation.screens.profile.personal.PersonalProfileViewModel
import com.redvelvet.xogame.presentation.screens.profile.users.navigateToUserProfile

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: PersonalProfileViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ProfileContent(state = state, onClickAvatar = { id -> navController.navigateToUserProfile(id) })
}

@Composable
fun ProfileContent(
    state: PersonalProfileUiState,
    onClickAvatar: (String) -> Unit
) {
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
            ProfileCard(state)
            VerticalSpacer(space = 32)
            LazyColumn(
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
            ) {
                items(state.friendRequests) {
                    OneFriendRequestCard(state = it, onClickAvatar = onClickAvatar)
                }
            }
        }

    }

}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileContent() {
    //ProfileContent()
}