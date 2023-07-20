package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dountapplication.screen.ProfilePicture
import com.redvelvet.xogame.R


@Composable
fun OneFriendRequestCard(imageUrl: String?, name: String?) {
    Row(
        modifier = Modifier
            .background(Color.White.copy(0.3f))
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfilePicture(imageUrl = imageUrl, pictureSize = 40)
            HorizontalSpacer(space = 16)
            TextProfileCard(text = name ?: "")
        }
        Row() {
            IncDec(imageResourceId = R.drawable.decline)
            HorizontalSpacer(space = 16)
            IncDec(imageResourceId = R.drawable.accept)
        }
    }
}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewOneFriendRequestCard() {
    OneFriendRequestCard(
        "https://ca.slack-edge.com/T04C8RRGPBL-U04KBCG985N-625b961bc451-512",
        "Kamel"
    )
}