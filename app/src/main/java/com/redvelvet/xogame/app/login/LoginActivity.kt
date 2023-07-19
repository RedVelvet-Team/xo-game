package com.redvelvet.xogame.app.login

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
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.screens.login.GoogleAuthViewModel
import com.redvelvet.xogame.presentation.screens.login.LoginScreen
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
            LoginScreen(state = state) { intentSender ->
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.signIn()
                    launcher.launch(
                        IntentSenderRequest.Builder(
                            intentSender ?: return@launch
                        ).build()
                    )
                }
            }
            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.sign_in_successful),
                        Toast.LENGTH_SHORT
                    ).show()
                    viewModel.resetState()
                }
            }
        }
    }
}
