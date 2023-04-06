package com.example.multimodule.data.github

import com.example.multimodule.data.github.response.GithubResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 *
 */
class GithubRepositoryImpl @Inject constructor(
    private val githubService: GithubService
): GithubRepository {
    override suspend fun getRepos(owner: String): Flow<List<GithubResponse>> =
        flow {
            emit(githubService.getRepos(owner))
        }
}