package com.redvelvet.xogame.domain.entity

data class SignInResult(
    val data: UserEntity?,
    val errorMessage: String?
)

data class UserEntity(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?,
    val email: String?,
)