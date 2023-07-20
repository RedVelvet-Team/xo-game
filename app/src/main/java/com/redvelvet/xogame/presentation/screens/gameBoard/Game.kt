package com.redvelvet.xogame.presentation.screens.gameBoard


enum class GameStatus {
    ONGOING,
    DRAW,
    X_WINS,
    O_WINS
}

data class Game(
    val board: List<List<Player?>>, // 3x3 grid of the board
    val currentPlayer: Player,
    val status: GameStatus = GameStatus.ONGOING,
    val winningCells: List<Pair<Int, Int>> = emptyList()
)

enum class Player { X, O }