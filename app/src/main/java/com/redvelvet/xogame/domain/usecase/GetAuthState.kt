package com.redvelvet.xogame.domain.usecase

import com.redvelvet.xogame.domain.repository.AuthGoogleRepo
import com.redvelvet.xogame.domain.repository.AuthStateResponse
import kotlinx.coroutines.CoroutineScope

class GetAuthState(
    private val repo: AuthGoogleRepo
) {
    operator fun invoke(
        viewModelScope: CoroutineScope
    ): AuthStateResponse = repo.getAuthState(viewModelScope)
}