package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.R

@Composable
fun WoodenHeader() {
    Image(
        alignment = Alignment.Center,
        painter = painterResource(id = R.drawable.home_header),
        contentDescription = stringResource(R.string.home_screen_image_with_blur_effect),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clipToBounds()
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
    )
}