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
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfilePicture(
    imageUrl: String?,
    pictureSize: Int,
    modifier: Modifier = Modifier
        .clip(CircleShape)
        .size(pictureSize.dp)
        .fillMaxWidth(),
) {
    val painter = rememberAsyncImagePainter(imageUrl ?: "")
    Image(
        painter = painter,
        contentDescription = "profile",
        modifier = modifier,
        contentScale = ContentScale.FillBounds,
        alignment = Alignment.TopCenter
    )
}