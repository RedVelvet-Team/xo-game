package com.redvelvet.xogame.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.ui.theme.StatusBarColor
import com.redvelvet.xogame.app.ui.theme.TabIndicatorColor
import com.redvelvet.xogame.app.ui.theme.White60
import com.redvelvet.xogame.presentation.composable.BeachBackGround
import com.redvelvet.xogame.presentation.composable.UsersSearchBar
import com.redvelvet.xogame.presentation.composable.UsersSection
import com.redvelvet.xogame.presentation.composable.WoodenHeader
import com.redvelvet.xogame.presentation.screens.profile.personal.navigateToProfile

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeScreenContent(state = state) {
        navController.navigateToProfile()
    }
}

@Composable
fun HomeScreenContent(
    state: HomeUiState,
    onMyProfilePhotoClicked: () -> Unit,
) {
    val systemUisController = rememberSystemUiController()
    systemUisController.setStatusBarColor(StatusBarColor, darkIcons = true)
    var tabIndex by remember { mutableStateOf(0) }
    var isFriend by remember { mutableStateOf(false) }
    var friends by remember { mutableStateOf(listOf<UserUiState>()) }
    LaunchedEffect(key1 = state) {
        friends = state.onlineFriends!!
    }
    Box(modifier = Modifier.fillMaxSize()) {
        BeachBackGround()
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                WoodenHeader()
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 72.dp)
                ) {
                    UsersSearchBar(
                        modifier = Modifier,
                        image = state.userUiState?.profilePictureUrl.toString(),
                        name = state.userUiState?.name.toString(),
                        onMyProfilePhotoClicked = onMyProfilePhotoClicked,
                    )
                    TabRow(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        selectedTabIndex = tabIndex,
                        containerColor = Color(0x20F5F5F5),
                        contentColor = Color.White,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                                color = TabIndicatorColor,
                                height = 3.0.dp,
                            )
                        }
                    ) {
                        Tab(
                            selected = tabIndex == 0,
                            onClick = {
                                tabIndex = 0
                                friends = state.onlineFriends!!
                                isFriend = false
                            },
                            text = {
                                Text(text = stringResource(R.string.online_players))
                            },
                            selectedContentColor = Color.White,
                            unselectedContentColor = White60
                        )
                        Tab(
                            selected = tabIndex == 1,
                            onClick = {
                                tabIndex = 1
                                friends = state.userUiState?.friends!!
                                isFriend = true
                            },
                            text = {
                                Text(text = stringResource(R.string.your_friends))
                            },
                            selectedContentColor = Color.White,
                            unselectedContentColor = White60,
                        )
                    }
                }

            }
            UsersSection(friends = friends, isFriend = isFriend)
        }
    }
}


