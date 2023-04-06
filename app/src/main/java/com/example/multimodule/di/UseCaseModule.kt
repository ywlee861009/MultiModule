package com.example.multimodule.di

import com.example.multimodule.data.github.GithubRepository
import com.example.multimodule.domain.GetGithubRepositoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetGithubRepositoryUseCase(
        githubRepository: GithubRepository
    ) = GetGithubRepositoryUseCase(githubRepository)
}