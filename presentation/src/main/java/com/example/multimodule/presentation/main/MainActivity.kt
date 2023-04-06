package com.example.multimodule.presentation.main

import android.content.Intent
import android.graphics.Color
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.transform.CircleCropTransformation
import com.example.multimodule.presentation.R
import com.example.multimodule.presentation.databinding.ActivityMainBinding
import com.example.multimodule.presentation.main.adapter.GithubAdapter
import com.example.multimodule.presentation.test.TestActivity
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

        Coil.setImageLoader(
            ImageLoader.Builder(this)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()
        )

        binding.ivLoading.load(R.drawable.loading)
        viewModel.getRepo()

        viewModel.loading.observe(this) {
            binding.recyclerView.isVisible = it.not()
            binding.ivLoading.isVisible = it
        }

        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.repos.observe(this) {
            (binding.recyclerView.adapter as? GithubAdapter)?.submitList(it)
        }

        binding.btnGoTest.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
}