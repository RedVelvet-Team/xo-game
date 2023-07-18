package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.dountapplication.screen.ProfilePicture
import com.redvelvet.xogame.R


@Composable
fun OneFriendRequestCard() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth().alpha(0.5f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
       ProfilePicture(imageResourceId = R.drawable.img_1, pictureSize = 40)
        TextProfileCard(text = "messi")
        Row() {
            IncDec(imageResourceId = R.drawable.decline)
            HorizontalSpacer(space = 16)
            IncDec(imageResourceId = R.drawable.accept)
        }
    }
}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewOneFriendRequestCard(){
    OneFriendRequestCard()
}