package com.redvelvet.xogame.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.xogame.R
import com.redvelvet.xogame.presentation.screens.home.BeachBackGround
import com.redvelvet.xogame.presentation.screens.home.WoodenHeader

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TesterAgain() {
    GameBoardScreen()
}

@Composable
fun GameBoardScreen() {
    GameBoardScreenContent(
        "Hassan Wasfy",
        R.drawable.baseline_circle_24,
        "Wasfy Hassan",
        R.drawable.baseline_circle_24
    )
}

@Composable
fun GameBoardScreenContent(
    p1Name: String, p1Image: Int,
    p2Name: String, p2Image: Int
) {
    Box(modifier = Modifier) {
        BeachBackGround()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier) {
                WoodenHeader()
                Players(p1Name, p1Image, p2Name, p2Image)
            }
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.game_board),
                    contentDescription = "game board image"
                )
                Column(
                    modifier = Modifier.padding(top = 52.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OneBoardRow()
                    OneBoardRow()
                    OneBoardRow()
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exit_button),
                    contentDescription = "exit button"
                )
                Image(
                    painter = painterResource(id = R.drawable.play_again_button),
                    contentDescription = "play again button"
                )
            }
        }
    }
}

@Composable
fun OneBoardRow(

) {
    Row(
        modifier = Modifier.padding(start = 45.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OneCard(true) {}
        OneCard(false) {}
        OneCard(true) {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneCard(isPlayerX: Boolean, onBoxClicked: () -> Unit) {
    Card(
        onClick = { onBoxClicked() }, modifier = Modifier
            .size(74.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Image(
            painter = painterResource(
                if (isPlayerX)
                    R.drawable.player_x else R.drawable.player_o
            ),
            contentDescription = "player type button",
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun Players(
    p1Name: String, p1Image: Int,
    p2Name: String, p2Image: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PlayerSide(p1Name, p1Image, true)
        Image(
            painter = painterResource(id = R.drawable.vs),
            contentDescription = "vs word",
            modifier = Modifier.size(32.dp),
            alignment = Alignment.Center
        )
        PlayerSide(p2Name, p2Image, false)
    }
}

@Composable
fun PlayerSide(name: String, image: Int, isPlayerX: Boolean) {
    Column(
        modifier = Modifier
            .padding(top = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "user image",
            modifier = Modifier.size(64.dp)
        )
        Text(text = name)
        Image(
            painter = painterResource(
                id = if (isPlayerX)
                    R.drawable.x else R.drawable.o
            ),
            contentDescription = "player x",
            modifier = Modifier.size(24.dp)
        )
    }
}
