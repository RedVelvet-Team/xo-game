package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.screens.home.UserUiState

@Composable
fun UsersSection(
    friends: List<UserUiState>,
    isFriend: Boolean,
    sendInvite: (String, String, String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            if (friends.isEmpty() && isFriend)
                OneUserRow(
                    image = "",
                    name = stringResource(R.string.sorry_you_don_t_have_friends_yet),
                    hasFriend = false,
                )
            else if (friends.isEmpty() && !isFriend)
                OneUserRow(
                    image = "",
                    name = stringResource(R.string.it_seems_no_one_is_online_now),
                    hasFriend = false,
                )
        }
        items(friends) {
            OneUserRow(
                image = it.profilePictureUrl.toString(),
                name = it.name.toString(),
                hasFriend = true,
                onClickInvite = sendInvite,
                id = it.id,
                senderName = it.name,
                senderImage = it.profilePictureUrl,
            )
        }
    }
}