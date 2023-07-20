package com.redvelvet.xogame.presentation.screens.gameBoard


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    private val _game = MutableStateFlow(
        Game(
        board = List(3) { List(3) { null } },
        currentPlayer = Player.X,
        status = GameStatus.ONGOING
    )
    )

    val game: StateFlow<Game> = _game.asStateFlow()

    fun onBoxClicked(x: Int, y: Int) {
        val currentGame = _game.value
        if (currentGame.board[x][y] != null) {
            return
        }

        // Update board with new move.
        val updatedBoard = currentGame.board.mapIndexed { xi, row ->
            row.mapIndexed { yi, player ->
                if (xi == x && yi == y) currentGame.currentPlayer else player
            }
        }

        // Check for winner and winning cells.
        val (gameStatus, winningCells) = checkForWinner(updatedBoard)

        // Update game state.
        _game.value = currentGame.copy(
            board = updatedBoard,
            currentPlayer = if (currentGame.currentPlayer == Player.X) Player.O else Player.X,
            status = gameStatus,
            winningCells = winningCells
        )
    }

    private fun checkForWinner(board: List<List<Player?>>): Pair<GameStatus, List<Pair<Int, Int>>> {
        // Rows
        for (i in board.indices) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return (if (board[i][0] == Player.X) GameStatus.X_WINS else GameStatus.O_WINS) to listOf(Pair(i,0), Pair(i,1), Pair(i,2))
            }
        }

        // Columns
        for (i in board.indices) {
            if (board[0][i] != null && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return (if (board[0][i] == Player.X) GameStatus.X_WINS else GameStatus.O_WINS) to listOf(Pair(0,i), Pair(1,i), Pair(2,i))
            }
        }

        // Diagonals
        if (board[0][0] != null && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return (if (board[0][0] == Player.X) GameStatus.X_WINS else GameStatus.O_WINS) to listOf(Pair(0,0), Pair(1,1), Pair(2,2))
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return (if (board[0][2] == Player.X) GameStatus.X_WINS else GameStatus.O_WINS) to listOf(Pair(0,2), Pair(1,1), Pair(2,0))
        }

        // Return winning cells with game status
        if (board[0][0] != null && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return (if (board[0][0] == Player.X) GameStatus.X_WINS else GameStatus.O_WINS) to listOf(Pair(0,0), Pair(1,1), Pair(2,2))
        }

        // Draw condition
        if (board.all { row -> row.all { it != null } }) {
            return GameStatus.DRAW to emptyList()
        }

        // If no winner and not draw, the game is ongoing.
        return GameStatus.ONGOING to emptyList()
    }

    fun resetGame() {
        _game.value = Game(
            board = List(3) { List(3) { null } },
            currentPlayer = Player.X,
            status = GameStatus.ONGOING
        )
    }
}