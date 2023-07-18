package com.example.dountapplication.screen


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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.ProfileCardRowStatistics
import com.redvelvet.xogame.presentation.composable.ProfileName

@Composable
fun ProfileCard() {
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
            )
        {
            Column(modifier = Modifier) {
                ProfilePicture(imageResourceId = R.drawable.img_1, pictureSize = 120)
                ProfileName(profileName = "Lionel Messi")
            }
        }
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
                    ProfileCardRowStatistics(title = "Games Played", value = "43")
                    ProfileCardRowStatistics(title = "Games Won", value = "12")
                    ProfileCardRowStatistics(title = "Games Draw", value = "10")
                    ProfileCardRowStatistics(title = "Friends", value = "2")

                }
            }
        }
    }
    }


@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileCard() {
    ProfileCard()
}