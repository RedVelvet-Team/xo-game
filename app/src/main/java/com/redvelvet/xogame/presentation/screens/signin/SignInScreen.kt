package com.redvelvet.xogame.presentation.screens.signin

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.xogame.R
import com.redvelvet.xogame.domain.model.Response
import com.redvelvet.xogame.domain.repository.SignInResponse
import kotlin.reflect.KProperty0


@Composable
fun SignInContent(
    onSignInClick: () -> Unit
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
        SpacerVertical(16)
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "you will exit from the game",
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(8.dp))
        )
        SpacerVertical(16)
        Text(
            text = "Use your personal Google account to log in here!",
            fontSize = 16.sp,
            color = Black,
            modifier = Modifier
                .padding(horizontal = 28.dp),
            textAlign = TextAlign.Center,
        )
        SpacerVertical(16)
        Button(
            modifier = Modifier
                .height(56.dp)
                .width(250.dp)
                .paint(
                    painter = painterResource(id = R.drawable.button_background)
                ),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            onClick = {
                onSignInClick()
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Transparent)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(
                    modifier = Modifier
                        .height(25.dp)
                        .width(24.dp),
                    painter = painterResource(R.drawable.google),
                    contentDescription = null,
                )
                SpacerHorizontal(space = 8)
                Text(
                    text = "Sign up with Google",
                    fontSize = 16.sp,
                )
            }
        }
    }
}


@Composable
fun SpacerVertical(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
}

@Composable
fun SpacerHorizontal(space: Int) {
    Spacer(modifier = Modifier.width(space.dp))
}
