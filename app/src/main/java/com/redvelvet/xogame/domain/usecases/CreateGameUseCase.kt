package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.GameRepository
import javax.inject.Inject

class CreateGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(player1: String, player2: String) =
        gameRepository.createGame(player1, player2)
}