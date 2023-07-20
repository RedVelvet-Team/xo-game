package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.dountapplication.screen.VerticalSpacer

@Composable
fun ProfileCardRowStatistics(title: String?, value: String?) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextProfileCard(text = title ?: "")
        TextProfileCard(text = value ?: "")
    }
    VerticalSpacer(space = 24)
}