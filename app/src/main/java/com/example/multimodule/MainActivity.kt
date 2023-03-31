package com.example.multimodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GithubClient.getApi().getRepos("ywlee861009")
            .enqueue(object: Callback<List<GithubRepo>> {
                override fun onResponse(
                    call: Call<List<GithubRepo>>,
                    response: Response<List<GithubRepo>>
                ) {

                }

                override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {

                }
            })
    }
}