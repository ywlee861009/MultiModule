package com.example.multimodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Main View model
 */
@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _repos = MutableLiveData<List<GithubRepo>>()
    val repos: LiveData<List<GithubRepo>>
        get() = _repos

    /**
     * github repo get
     */
    fun getRepo() {
        GithubClient.getApi().getRepos("ywlee861009")
            .enqueue(object: Callback<List<GithubRepo>> {
                override fun onResponse(
                    call: Call<List<GithubRepo>>,
                    response: Response<List<GithubRepo>>
                ) {
                    response.body()?.let {
                        _repos.value = it
                    }
                }

                override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                    _error.value = t.toString()
                }
            })
    }
}