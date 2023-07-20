package com.redvelvet.xogame.domain.repository

import android.content.Intent
import android.content.IntentSender
import com.redvelvet.xogame.domain.entity.FriendEntity
import com.redvelvet.xogame.domain.entity.UserEntity

interface AuthGoogleRepository {
    suspend fun signIn(): IntentSender?

    suspend fun signInWithIntent(intent: Intent): Result<Boolean>

    suspend fun signOut()

    suspend fun getSignedInUser(): UserEntity?
    suspend fun getUserById(userId: String): UserEntity?

    suspend fun checkIfUserIsLoggedIn(): Boolean

    suspend fun updateUserStatue(status: String)

    suspend fun getOnlineFriends(): List<FriendEntity>
}