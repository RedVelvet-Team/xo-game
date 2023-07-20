package com.redvelvet.xogame.presentation.screens.profile.users

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.xogame.domain.usecases.GetProfileByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getProfileByIdUseCase: GetProfileByIdUseCase,
    savedStateHandle: SavedStateHandle
) {
}