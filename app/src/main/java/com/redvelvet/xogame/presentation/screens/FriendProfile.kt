package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dountapplication.screen.VerticalSpacer
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.ProfileAppbar
import com.redvelvet.xogame.presentation.composable.ProfileButton
import com.redvelvet.xogame.presentation.composable.ProfileCard

@Composable
fun FriendProfile(
    imageUrl: String,
    profileName: String,
    gamesPlayedValue: Int,
    gamesWon: Int,
    gamesDraw: Int,
    friendsValue: Int
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
            ProfileCard(
                imageUrl = imageUrl,
                profileName = profileName,
                gamesPlayedValue = gamesPlayedValue,
                gamesWon = gamesWon,
                gamesDraw = gamesDraw,
                friendsValue = friendsValue
            )
            VerticalSpacer(space = 32)
            ProfileButton(text = "Invite to Play")
            VerticalSpacer(space = 12)
            ProfileButton(text = "Remove Friend")
            }
        }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewFriendProfile() {
    FriendProfile(
        "https://ca.slack-edge.com/T04C8RRGPBL-U04KBCG985N-625b961bc451-512",
        "Kamel",
        34,
        55,
        46,
        56
    )
}