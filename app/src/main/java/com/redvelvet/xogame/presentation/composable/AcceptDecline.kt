package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun IncDec(
    imageResourceId: Int,
    cardColors: CardColors = CardDefaults.cardColors(Color.White)
){
    Card(
        modifier = Modifier
            .alpha(0.5f),
        colors = cardColors,
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = "friend decision",
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier.size(24.dp).padding(vertical = 7.dp, horizontal = 5.dp)
            )
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun PreviewIncDec(){
   // IncDec(R.drawable.img_1)
}