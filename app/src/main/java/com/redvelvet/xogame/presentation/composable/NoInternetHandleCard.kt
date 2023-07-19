package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.xogame.R

@Composable
fun NoInternetHandle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(274.dp)
            .width(312.dp)
            .paint(
                painterResource(id = R.drawable.layer_1)
            )
            .padding(horizontal = 32.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        SpacerVertical(8)
        Image(
            painterResource(id = R.drawable.nowifi),
            contentDescription = "you will exit from the game",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        SpacerVertical(16)
        Title(text = "No Internet Connection please try again")
        SpacerVertical(space = 16)
        CustomButton(text = "Try Again") {

        }
    }
}

@Composable
fun Title(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 28.dp),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CustomButton(
    text: String,
    onClickTryAgain: () -> Unit
) {
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = onClickTryAgain,
        modifier = Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.button_background)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = text,
            color = Color.White,
            maxLines = 1,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun SpacerVertical(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
}