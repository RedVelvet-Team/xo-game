package com.redvelvet.xogame.presentation.screens.splash

sealed class SplashUiEffect{
    object GoToHomeUiEffect:SplashUiEffect()
    object GoToSignUpUiEffect:SplashUiEffect()
}
