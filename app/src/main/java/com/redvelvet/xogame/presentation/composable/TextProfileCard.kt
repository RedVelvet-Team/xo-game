package com.redvelvet.xogame.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextProfileCard(text: String){
    Text(
        text = text,
        color = Color.Black,
        fontWeight = FontWeight(400),
        fontSize = 14.sp,
        )
}