package com.example.multimodule.data.github

import com.example.multimodule.data.github.response.GithubResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Github api service
 */
interface GithubService {
    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String): List<GithubResponse>
}