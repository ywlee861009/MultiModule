package com.example.multimodule

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * github client
 */
class GithubClient {
    companion object {
        private const val BASE_URL = "https://api.github.com"

        /**
         * github service client 생성
         *
         * @return [GithubService]
         */
        fun getApi(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}