package com.example.multimodule.domain

import com.example.multimodule.data.GithubRepository
import com.example.multimodule.domain.entity.GithubEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Github 저장소 가져오는 use case
 */
class GetGithubRepositoryUseCase(
    private val githubRepository: GithubRepository
) {
    suspend fun getRepo(owner: String?): Flow<List<GithubEntity>> =
        owner?.let {
            githubRepository.getRepos(it)
        } ?: flow {
            throw Exception()
        }
}