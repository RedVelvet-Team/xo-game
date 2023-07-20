package com.redvelvet.xogame.presentation.screens.gameBoard

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.xogame.R
import com.redvelvet.xogame.app.ui.theme.WinnerO
import com.redvelvet.xogame.app.ui.theme.WinnerX
import com.redvelvet.xogame.presentation.composable.BeachBackGround
import com.redvelvet.xogame.presentation.composable.WoodenHeader

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
    p2Name: String, p2Image: Int,
    gameViewModel: GameViewModel = hiltViewModel()
) {
    val game by gameViewModel.game.collectAsState()
    var visible by remember {
        mutableStateOf(false)
    }
    when (game.status) {
        GameStatus.X_WINS -> {
            ShowToast(message = "X has won the game")
            visible = true
        }

        GameStatus.O_WINS -> {
            ShowToast(message = "O has won the game")
            visible = true
        }

        GameStatus.DRAW -> {
            ShowToast(message = "The game is a draw")
            visible = true
        }

        else -> {
            visible = false
        }
    }

    Box(modifier = Modifier) {
        BeachBackGround()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
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
                    game.board.forEachIndexed { rowIndex, row ->
                        OneBoardRow(row, rowIndex, gameViewModel)
                    }
                }
            }
            if (visible)
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
                        contentDescription = "play again button",
                        modifier = Modifier.clickable { gameViewModel.resetGame() }
                    )
                }
        }
    }
}

@Composable
fun OneBoardRow(row: List<Player?>, x: Int, gameViewModel: GameViewModel) {
    Row(
        modifier = Modifier.padding(start = 45.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        row.forEachIndexed { y, player ->
            OneCard(player, x, y, gameViewModel)
        }
    }
}

@Composable
fun ShowToast(message: String) {
    val context = LocalContext.current
    LaunchedEffect(key1 = message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneCard(player: Player?, x: Int, y: Int, gameViewModel: GameViewModel) {
    val game by gameViewModel.game.collectAsState()
    val playerImage = when (player) {
        Player.X -> R.drawable.player_x
        Player.O -> R.drawable.player_o
        else -> null
    }

    val backgroundColor = when {
        (game.winningCells.contains(Pair(x, y)) && game.status == GameStatus.X_WINS) -> WinnerX
        (game.winningCells.contains(Pair(x, y)) && game.status == GameStatus.O_WINS) -> WinnerO
        else -> Color.Transparent
    }

    Card(
        onClick = { gameViewModel.onBoxClicked(x, y) },
        modifier = Modifier.size(74.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        playerImage?.let { playerImage ->
            Image(
                painter = painterResource(playerImage),
                contentDescription = "player type button",
                alignment = Alignment.Center,
                colorFilter = if (game.winningCells.contains(
                        Pair(
                            x,
                            y
                        )
                    ) && (game.status == GameStatus.X_WINS || game.status == GameStatus.O_WINS)
                ) ColorFilter.tint(Color.White) else null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
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
            contentDescription = if (isPlayerX) "player x" else "player o",
            modifier = Modifier.size(24.dp)
        )
    }
}
