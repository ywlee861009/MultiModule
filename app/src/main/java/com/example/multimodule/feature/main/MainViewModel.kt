package com.example.multimodule.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multimodule.data.GithubRepository
import com.example.multimodule.data.github.response.GithubResponse
import com.example.multimodule.domain.entity.GithubEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main View model
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubRepository: GithubRepository
): ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _repos = MutableLiveData<List<GithubEntity>>()
    val repos: LiveData<List<GithubEntity>>
        get() = _repos

    /**
     * github repo get
     */
    fun getRepo() {
        viewModelScope.launch {
            githubRepository.getRepos("ywlee861009")
                .catch {t ->
                    _error.postValue(t.toString())
                }
                .collect { response ->
                    _repos.postValue(response)
                }
        }
    }
}