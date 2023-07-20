package com.redvelvet.xogame.app.di

import com.redvelvet.xogame.data.repository.AuthGoogleRepoImpl
import com.redvelvet.xogame.data.repository.GameRepositoryImpl
import com.redvelvet.xogame.domain.repository.AuthGoogleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAuthGoogleRepository(authGoogleRepoImpl: AuthGoogleRepoImpl): AuthGoogleRepository

    @Singleton
    @Binds
    abstract fun bindGameRepository(gameRepositoryImpl: GameRepositoryImpl): GameRepositoryImpl
}