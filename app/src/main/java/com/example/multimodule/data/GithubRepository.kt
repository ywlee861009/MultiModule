package com.example.multimodule.data

import com.example.multimodule.data.github.GithubService
import com.example.multimodule.data.github.response.toEntities
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Github 관련 Repository
 */
class GithubRepository @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun getRepos(owner: String?) =
        flow {
            owner?.let {
                emit(githubService.getRepos(it))
            } ?: throw Exception()
        }.map {
            it.toEntities()
        }
}