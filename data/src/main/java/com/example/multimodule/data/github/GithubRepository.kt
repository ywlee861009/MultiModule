package com.example.multimodule.data.github

import com.example.multimodule.data.github.response.GithubResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Github 관련 Repository
 */
interface GithubRepository {
    suspend fun getRepos(owner: String): Flow<List<GithubResponse>>
}