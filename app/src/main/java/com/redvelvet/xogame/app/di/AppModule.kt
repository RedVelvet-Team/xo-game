package com.redvelvet.xogame.app.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.redvelvet.xogame.data.remote.repository.AuthGoogleRepoImpl
import com.redvelvet.xogame.domain.repository.AuthGoogleRepo
import com.redvelvet.xogame.domain.usecase.GetAuthState
import com.redvelvet.xogame.domain.usecase.SignIn
import com.redvelvet.xogame.domain.usecase.SignOut
import com.redvelvet.xogame.domain.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Singleton
    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth
    ): AuthGoogleRepo = AuthGoogleRepoImpl(auth)

    @Singleton
    @Provides
    fun provideUseCases(
        repo: AuthGoogleRepo
    ) = UseCases(
        getAuthState = GetAuthState(repo),
        signIn = SignIn(repo),
        signOut = SignOut(repo)
    )
}