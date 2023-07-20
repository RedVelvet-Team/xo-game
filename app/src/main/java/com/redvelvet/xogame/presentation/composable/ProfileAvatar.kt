package com.example.dountapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun ProfileAvatar(
    imageUrl: String,
    pictureSize: Int,
    id: String = "",
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
        .clip(CircleShape)
        .size(pictureSize.dp)
        .fillMaxWidth()
        .clickable { onClick(id) },
) {
    val newModifier = if (id != "") modifier else Modifier
        .clip(CircleShape)
        .size(pictureSize.dp)
        .fillMaxWidth()
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = "profile",
        modifier = newModifier,
        contentScale = ContentScale.FillBounds,
        alignment = Alignment.TopCenter
    )
}