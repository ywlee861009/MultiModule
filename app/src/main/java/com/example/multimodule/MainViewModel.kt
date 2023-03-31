package com.example.multimodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            flow {
                emit(GithubClient.getApi().getRepos("ywlee861009"))
            }.catch {t ->
                _error.postValue(t.toString())
            }
            .collect { response ->
                _repos.postValue(response)
            }
        }
    }
}