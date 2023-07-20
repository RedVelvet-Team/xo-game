package com.redvelvet.xogame.presentation.composable


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dountapplication.screen.ProfileAvatar
import com.redvelvet.xogame.presentation.screens.profile.personal.PersonalProfileUiState

@Composable
fun ProfileCard(state: PersonalProfileUiState) {
    Column() {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White.copy(alpha = 0.3f), Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 120.dp)
                ) {
                    ProfileCardRowStatistics(
                        title = "Games Played",
                        value = state.gamesPlayed.toString()
                    )
                    ProfileCardRowStatistics(title = "Games Won", value = state.gamesWon.toString())
                    ProfileCardRowStatistics(
                        title = "Games Draw",
                        value = state.gamesDraw.toString()
                    )
                    ProfileCardRowStatistics(
                        title = "Friends",
                        value = state.friendsCount.toString()
                    )
                }
            }

            Column(
                modifier = Modifier
                    .offset(x = 0.dp, y = (-80).dp)
            ) {
                ProfileAvatar(state.image, pictureSize = 120)
                ProfileName(profileName = state.name)
            }
        }
    }
}


@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileCard() {
    //ProfileCard()
}