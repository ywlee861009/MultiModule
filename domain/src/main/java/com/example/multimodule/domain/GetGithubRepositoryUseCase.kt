package com.example.multimodule.domain

import com.example.multimodule.data.github.GithubRepository
import com.example.multimodule.domain.entity.GithubEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Github 저장소 가져오는 use case
 */
class GetGithubRepositoryUseCase(
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(owner: String?): Flow<List<GithubEntity>> =
        owner?.let {
            githubRepository.getRepos(it)
                .map { responseList ->
                    responseList.map { response ->
                        GithubEntity(
                            name = response.name ?: "",
                            id = response.id ?: "",
                            date = response.date ?: "",
                            url = response.url ?: ""
                        )
                    }
                }
        } ?: flow {
            throw Exception()
        }
}