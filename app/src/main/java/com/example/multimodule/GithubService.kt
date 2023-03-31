package com.example.multimodule

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Github api service
 */
interface GithubService {
    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String): List<GithubRepo>
}