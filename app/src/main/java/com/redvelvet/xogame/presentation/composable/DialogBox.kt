package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redvelvet.xogame.R

@Preview(showSystemUi = true)
@Composable
fun k() {
    DialogBox()
}

@Composable
fun DialogBox() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(300.dp)
            .width(320.dp)
            .paint(
                painterResource(id = R.drawable.layer_1)
            )
            .padding(horizontal = 32.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        SpacerVertical(8)
        PlayerAvatar(avatar = R.drawable.ronaldo)
        SpacerVertical(16)
        PlayerRequest(name = "CR7")
        SpacerVertical(space = 4)
        Text(
            text = stringResource(R.string.has_invited_to_play_with_them),
            fontSize = 14.sp,
            maxLines = 1,
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 28.dp),
            textAlign = TextAlign.Center,
        )
        SpacerVertical(16)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CustomButton(text = stringResource(R.string.deny)) {

            }
            HorizontalSpacer(space = 4)
            CustomButton(text = stringResource(R.string.accept)) {

            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    onButtonClick: () -> Unit
) {
    Button(
        elevation = ButtonDefaults.buttonElevation(0.dp),
        onClick = onButtonClick,
        modifier = Modifier
            .width(130.dp)
            .paint(
                painter = painterResource(id = R.drawable.button_background)
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Text(
            text = text,
            color = Color.White,
            maxLines = 1,
            fontSize = 20.sp
        )
    }
}

@Composable
fun PlayerAvatar(
    avatar: Int
) {
    Image(
        painterResource(id = avatar),
        contentDescription = null,
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
    )
}

@Composable
fun PlayerRequest(
    name: String,
) {
    Text(
        text = name,
        fontSize = 20.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 28.dp),
        textAlign = TextAlign.Center,
    )
}