package com.redvelvet.xogame.presentation.screens

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.screens.home.navigateToHome
import com.redvelvet.xogame.presentation.screens.splash.SplashUiEffect
import com.redvelvet.xogame.presentation.screens.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val effect: SplashUiEffect by viewModel.effect
        .collectAsState(initial = SplashUiEffect.GoToHomeUiEffect)
    SplashContent(effect = effect, navController)
}

@Composable
fun SplashContent(
    effect: SplashUiEffect,
    navController: NavController
) {
    val systemUisController = rememberSystemUiController()
    systemUisController.setStatusBarColor(Color.Transparent)
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 650,
                easing = { OvershootInterpolator(2f).getInterpolation(it) })
        )
        delay(3000)
        when (effect) {
            SplashUiEffect.GoToHomeUiEffect -> navController.navigateToHome()
            SplashUiEffect.GoToSignUpUiEffect -> navController
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
