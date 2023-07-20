package com.redvelvet.xogame.presentation.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.redvelvet.xogame.app.ui.theme.cardTextColor

@Composable
fun ProfileName(profileName: String){
    Text(
        text = profileName,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = cardTextColor
    )
}