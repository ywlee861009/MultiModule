package com.example.multimodule.data.github

import com.example.multimodule.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * github client
 */
class GithubClient {
    companion object {
        /**
         * github service client 생성
         *
         * @return [GithubService]
         */
        fun getApi(): GithubService = Retrofit.Builder()
            .baseUrl(Const.API_BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}