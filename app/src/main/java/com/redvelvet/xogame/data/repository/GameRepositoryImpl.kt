package com.redvelvet.xogame.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.redvelvet.xogame.domain.repository.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val databaseFireStore: FirebaseFirestore,
) : GameRepository {
    override suspend fun streamInviteGamePlay(): DocumentReference {
        return databaseFireStore.collection(INVITES).document(auth.uid.toString())
    }

    companion object {
        private const val INVITES = "invites"
    }
}