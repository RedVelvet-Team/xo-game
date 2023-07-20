package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.GameRepository
import javax.inject.Inject

class GetInvitedGameUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke() =
        gameRepository.streamInviteGamePlay()
}