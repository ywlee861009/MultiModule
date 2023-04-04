package com.example.multimodule.data

import com.example.multimodule.data.github.GithubService
import com.example.multimodule.data.github.response.GithubResponse
import com.example.multimodule.data.github.response.toEntities
import com.example.multimodule.domain.entity.GithubEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Github 관련 Repository
 */
class GithubRepository @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun getRepos(owner: String): Flow<List<GithubResponse>> =
        flow {
            emit(githubService.getRepos(owner))
        }
}