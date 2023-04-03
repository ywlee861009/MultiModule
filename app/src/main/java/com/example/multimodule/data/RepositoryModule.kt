package com.example.multimodule.data

import com.example.multimodule.data.github.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Repositories
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGithubRepository(githubService: GithubService) =
        GithubRepository(githubService)
}