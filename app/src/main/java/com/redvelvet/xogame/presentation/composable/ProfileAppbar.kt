package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.xogame.R

@Composable
fun ProfileAppbar(){
Row( 
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
) {
    Image(
        painter = painterResource(id = R.drawable.back_svgrepo_com),
        contentDescription = "back",
        colorFilter = ColorFilter.tint(Color.White)
    )
}
}
@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewProfileAppbar(){
    ProfileAppbar()
}
