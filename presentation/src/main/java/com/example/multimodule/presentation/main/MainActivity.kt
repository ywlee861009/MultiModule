package com.example.multimodule.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.multimodule.presentation.R
import com.example.multimodule.presentation.databinding.ActivityMainBinding
import com.example.multimodule.presentation.main.adapter.GithubAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.adapter = GithubAdapter()

        viewModel.getRepo()
        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.repos.observe(this) {
            (binding.recyclerView.adapter as? GithubAdapter)?.submitList(it)
        }
    }
}