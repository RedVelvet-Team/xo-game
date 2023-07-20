package com.redvelvet.xogame.domain.mapper

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.presentation.composable.ProfileCard
import com.example.dountapplication.screen.VerticalSpacer
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.composable.OneFriendRequestCard
import com.redvelvet.xogame.presentation.composable.ProfileAppbar

@Composable
fun ProfileScreen(){

}

@Composable
fun ProfileContent(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.background_img), contentDescription = "background" )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            VerticalSpacer(space = 48)
            ProfileAppbar()
            VerticalSpacer(space = 56)
            ProfileCard()
            VerticalSpacer(space = 32)
            LazyColumn(
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
            ) {
                item{
                    OneFriendRequestCard()
                    OneFriendRequestCard()
                    OneFriendRequestCard()
                }
            }
        }

    }

}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileContent(){
    ProfileContent()
}