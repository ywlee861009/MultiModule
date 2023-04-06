package com.example.multimodule.domain.di

import com.example.multimodule.data.github.GithubRepository
import com.example.multimodule.data.github.GithubRepositoryImpl
import com.example.multimodule.data.github.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Repositories
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGithubRepository(githubService: GithubService): GithubRepository =
        GithubRepositoryImpl(githubService)
}