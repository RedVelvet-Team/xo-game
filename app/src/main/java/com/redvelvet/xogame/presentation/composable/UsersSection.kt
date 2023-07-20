package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.presentation.screens.home.UserUiState

@Composable
fun UsersSection(friends: List<UserUiState>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            if (friends.isEmpty())
                OneUserRow(
                    image = "",
                    name = "Sorry, you don't have friends yet",
                    hasFriend = false,
                )
        }
        items(friends) {
            OneUserRow(
                image = it.profilePictureUrl.toString(),
                name = it.name.toString(),
                hasFriend = true
            )
        }
    }
}