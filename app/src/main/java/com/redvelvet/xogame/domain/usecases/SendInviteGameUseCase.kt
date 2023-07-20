package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.GameRepository
import javax.inject.Inject

class SendInviteGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(id: String, name: String, image: String) =
        gameRepository.sendInviteGamePlay(id, name, image)
}