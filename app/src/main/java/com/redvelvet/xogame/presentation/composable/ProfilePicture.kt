package com.example.dountapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePicture(
    imageResourceId: Int,
    pictureSize: Int,
    modifier: Modifier = Modifier
        .clip(CircleShape)
        .size(pictureSize.dp)
        .fillMaxWidth(),
) {
    Image(
        painter = painterResource(id = imageResourceId),
        contentDescription = "profile",
        modifier = modifier,
        contentScale = ContentScale.FillBounds,
        alignment = Alignment.TopCenter
    )
}