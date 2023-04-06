package com.example.multimodule.presentation.test

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.multimodule.presentation.R
import com.example.multimodule.presentation.databinding.ActivityTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestActivity: AppCompatActivity() {

    private val binding: ActivityTestBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_test)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.ivCircle.load("https://picsum.photos/200")
        binding.ivCircle.setOnClickListener {
            if (binding.ivCircle.strokeWidth == 0f) {
                binding.ivCircle.strokeWidth = 20f
            } else {
                binding.ivCircle.strokeWidth = 0f
            }
        }
    }
}