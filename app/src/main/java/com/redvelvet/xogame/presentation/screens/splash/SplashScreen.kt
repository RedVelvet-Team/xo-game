package com.redvelvet.xogame.presentation.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.LoginNavigationRoutes.LOGIN_ROUTE
import com.redvelvet.xogame.app.LoginNavigationRoutes.SPLASH_ROUTE
import com.redvelvet.xogame.app.ui.theme.StatusBarColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel(),
    goToHomeScreen: () -> Unit = {},
) {
    val state by viewModel.state.collectAsState()
    SplashContent(navController, state = state, goToHomeScreen = goToHomeScreen)
}

@Composable
private fun SplashContent(
    navController: NavController,
    state: SplashScreenUiState,
    goToHomeScreen: () -> Unit,
) {
    val systemUisController = rememberSystemUiController()
    systemUisController.setStatusBarColor(StatusBarColor, darkIcons = true)
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = state) {
        scale.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 650,
                easing = { OvershootInterpolator(2f).getInterpolation(it) })
        )
        delay(2000)
        if (!state.isLogged) {
            navController.navigate(LOGIN_ROUTE) { popUpTo(SPLASH_ROUTE) { inclusive = true } }
        } else {
            goToHomeScreen()
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_background),
            contentDescription = stringResource(R.string.background),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.tic_tac_toe_logo),
            modifier = Modifier.scale(scale.value)
        )
    }
}
