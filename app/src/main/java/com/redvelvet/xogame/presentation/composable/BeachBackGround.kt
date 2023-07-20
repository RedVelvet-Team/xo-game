package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.redvelvet.xogame.R

@Composable
fun BeachBackGround() {
    Image(
        painter = painterResource(id = R.drawable.home_background),
        contentDescription = "Home Screen Image With blur effect",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
    )
}