package com.redvelvet.xogame.domain.usecases

import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import javax.inject.Inject

class GoogleSignOutUserUseCase @Inject constructor(
    private val authGoogleRepository: AuthGoogleRepository
){
    suspend operator fun invoke(){
        authGoogleRepository.signOut()
    }
}