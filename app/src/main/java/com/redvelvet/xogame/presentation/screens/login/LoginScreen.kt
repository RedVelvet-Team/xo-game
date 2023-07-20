package com.redvelvet.xogame.presentation.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dountapplication.screen.VerticalSpacer
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.ui.theme.Black87
import com.redvelvet.xogame.app.ui.theme.StatusBarColor
import com.redvelvet.xogame.app.ui.theme.passion
import com.redvelvet.xogame.presentation.composable.HorizontalSpacer


@Composable
fun LoginScreen(
    state: SignInUiState,
    onSignInClick: () -> Unit,
) {
    LoginContent(state = state, onSignInClick = onSignInClick)
}

@Composable
fun LoginContent(
    state: SignInUiState,
    onSignInClick: () -> Unit,
) {
    val systemUisController = rememberSystemUiController()
    systemUisController.setStatusBarColor(StatusBarColor, darkIcons = true)
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = stringResource(
                id = R.string.background
            ),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(274.dp)
                    .width(312.dp)
                    .paint(
                        painterResource(id = R.drawable.layer_1)
                    )
                    .padding(horizontal = 32.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                VerticalSpacer(16)
                Image(
                    painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.you_will_exit_from_the_game),
                    modifier = Modifier
                        .width(93.dp)
                        .height(65.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                )
                VerticalSpacer(16)
                Text(
                    text = stringResource(R.string.use_your_personal_google_account_to_log_in_here),
                    fontSize = 16.sp,
                    fontFamily = passion,
                    fontWeight = FontWeight.Normal,
                    color = Black87,
                    modifier = Modifier
                        .padding(horizontal = 28.dp),
                    textAlign = TextAlign.Center,
                )
                VerticalSpacer(16)
                Button(
                    modifier = Modifier
                        .height(56.dp)
                        .width(250.dp)
                        .paint(
                            painter = painterResource(id = R.drawable.button_background)
                        ),
                    elevation = ButtonDefaults.buttonElevation(0.dp),
                    onClick = { onSignInClick() },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .height(25.dp)
                                .width(24.dp),
                            painter = painterResource(R.drawable.google),
                            contentDescription = null,
                        )
                        HorizontalSpacer(space = 8)
                        Text(
                            text = stringResource(R.string.sign_up_with_google),
                            fontSize = 20.sp,
                            fontFamily = passion,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    }
                }
            }
        }

    }

}