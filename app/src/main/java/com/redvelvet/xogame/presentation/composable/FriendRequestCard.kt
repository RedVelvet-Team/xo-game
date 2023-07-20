package com.redvelvet.xogame.presentation.composable



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dountapplication.screen.VerticalSpacer

@Composable
fun FriendRequestCard(
    imageUrl: String,
    profileName: String,
    gamesPlayedValue: Int,
    gamesWon: Int,
    gamesDraw: Int,
    friendsValue: Int
) {
    Column {
        ProfileName(profileName = "Friend Request Received")
        VerticalSpacer(space = 28)
        OneFriendRequestCard(imageUrl = imageUrl, name = profileName)
        Box(modifier = Modifier.offset(x = 0.dp, y = (-80).dp)) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.5f),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 120.dp)
                ) {
                    ProfileCardRowStatistics(
                        title = "Games Played",
                        value = gamesPlayedValue.toString()
                    )
                    ProfileCardRowStatistics(title = "Games Won", value = gamesWon.toString())
                    ProfileCardRowStatistics(title = "Games Draw", value = gamesDraw.toString())
                    ProfileCardRowStatistics(title = "Friends", value = friendsValue.toString())

                }
            }
        }
    }
}



@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewFriendRequestCard() {
    FriendRequestCard(
        "https://ca.slack-edge.com/T04C8RRGPBL-U04KBCG985N-625b961bc451-512",
        "kamel",
        1,
        34,
        56,
        76
    )
}