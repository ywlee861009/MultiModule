package com.example.multimodule

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Github api service
 */
interface GithubService {
    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner: String): Call<List<GithubRepo>>
}