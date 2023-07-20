package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.R


@Composable
fun ProfileButton(
    modifier: Modifier = Modifier,
    text: String
){
    Button(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.buttonbackground)
            ),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = {

        },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Transparent)
    ) {
        Text(text = text)
    }
}