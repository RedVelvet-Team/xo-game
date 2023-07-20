package com.redvelvet.xogame.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.xogame.R


@Composable
fun DialogBox(
    setShowDialog: (Boolean) -> Unit,
    image: String?,
    name: String?,
    userId: String?,
    inviterId: String?,
    onAcceptClick: (String, String) -> Unit,
    onDeclineClick: () -> Unit,
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight(0.62f)
                .fillMaxWidth()
                .background(Color.Transparent)
                .paint(
                    painterResource(id = R.drawable.layer_1),
                    contentScale = ContentScale.FillBounds,
                ),
            verticalArrangement = Arrangement.Center,
        ) {
            SpacerVertical(8)
            PlayerAvatar(avatar = image)
            SpacerVertical(16)
            PlayerRequest(name = name)
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
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CustomButton(text = stringResource(R.string.deny)) {
                    onDeclineClick()
                }
                HorizontalSpacer(space = 4)
                CustomButton(text = stringResource(R.string.accept)) {
                    onAcceptClick(userId.toString(), inviterId.toString())
                }
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
            .width(135.dp)
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
    avatar: String?
) {
    Image(
        rememberAsyncImagePainter(model = avatar),
        contentDescription = stringResource(R.string.profile_picture),
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
    )
}

@Composable
fun PlayerRequest(
    name: String?,
) {
    Text(
        text = name.toString(),
        fontSize = 20.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(horizontal = 28.dp),
        textAlign = TextAlign.Center,
    )
}