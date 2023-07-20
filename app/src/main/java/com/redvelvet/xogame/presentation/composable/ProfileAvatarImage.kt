package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.xogame.R

@Composable
fun ProfileAvatarImage(
    image: String,
    onMyProfilePhotoClicked: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .size(60.dp)
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .background(Color.Transparent),
        shape = CircleShape
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onMyProfilePhotoClicked),
            painter = rememberAsyncImagePainter(
                model = image,
                contentScale = ContentScale.Crop,
            ),
            contentDescription = stringResource(id = R.string.user_image),
        )
    }
}