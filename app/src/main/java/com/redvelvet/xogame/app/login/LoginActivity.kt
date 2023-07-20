package com.redvelvet.xogame.app.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.home.HomeActivity
import com.redvelvet.xogame.app.navigate.LoginNavigationRoutes.LOGIN_ROUTE
import com.redvelvet.xogame.app.navigate.LoginNavigationRoutes.SPLASH_ROUTE
import com.redvelvet.xogame.presentation.screens.login.GoogleAuthViewModel
import com.redvelvet.xogame.presentation.screens.login.LoginScreen
import com.redvelvet.xogame.presentation.screens.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<GoogleAuthViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val navController = rememberNavController()

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            val signInResult = viewModel.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )
            NavHost(navController = navController, startDestination = SPLASH_ROUTE) {
                composable(SPLASH_ROUTE) {
                    SplashScreen(navController) {
                        navigateToHomeScreen(this@LoginActivity)
                    }
                }
                composable(LOGIN_ROUTE) {
                    LoginScreen(state = state) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            launcher.launch(
                                IntentSenderRequest.Builder(
                                    viewModel.signIn() ?: return@launch
                                ).build()
                            )
                        }
                    }
                }
            }

            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.sign_in_successful),
                        Toast.LENGTH_SHORT
                    ).show()
                    navigateToHomeScreen(this@LoginActivity)
                    viewModel.resetState()
                }
            }
        }
    }
}

private fun navigateToHomeScreen(activity: LoginActivity) {
    val intent = Intent(activity, HomeActivity::class.java)
    activity.startActivity(intent)
    activity.finish()
}