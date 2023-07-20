package com.redvelvet.xogame.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.redvelvet.xogame.domain.repository.GameRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val databaseFireStore: FirebaseFirestore,
) : GameRepository {
    override suspend fun streamInviteGamePlay(): DocumentReference {
        return databaseFireStore.collection(INVITES).document(auth.uid.toString())
    }

    override suspend fun sendInviteGamePlay(id: String, name: String, image: String) {
        val update = mapOf(
            "invited" to true,
            "name" to name,
            "image" to image,
        )
        Log.i("KAMELOO", update.toString())
        databaseFireStore.collection(INVITES)
            .document(id)
            .set(update)
            .await()
    }

    override suspend fun declineGame() {
        databaseFireStore.collection(INVITES)
            .document(auth.uid.toString())
            .update("invited", false)
            .await()
    }

    companion object {
        private const val INVITES = "invites"
    }
}