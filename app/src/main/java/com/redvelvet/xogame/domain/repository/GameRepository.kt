package com.redvelvet.xogame.domain.repository


import com.google.firebase.firestore.DocumentReference

interface GameRepository {
    suspend fun streamInviteGamePlay(): DocumentReference

    suspend fun sendInviteGamePlay(id: String,name:String,image:String)

    suspend fun declineGame()
}