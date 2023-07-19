package com.redvelvet.xogame.app.di

import android.content.Context
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.redvelvet.xogame.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideFireBaseAuth() = Firebase.auth

    @Singleton
    @Provides
    fun provideFireBaseFireStore() = Firebase.firestore

    @Singleton
    @Provides
    fun provideWebClientId(@ApplicationContext context: Context) =
        context.getString(R.string.web_cliend_id)

    @Singleton
    @Provides
    fun provideSignInClient(@ApplicationContext context: Context) =
        Identity.getSignInClient(context)
}