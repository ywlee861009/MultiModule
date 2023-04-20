package com.example.multimodule.presentation.test

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.multimodule.presentation.R
import com.example.multimodule.presentation.databinding.ActivityTestBinding
import com.example.multimodule.presentation.test.adapter.TestAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestActivity: AppCompatActivity() {

    private val binding: ActivityTestBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_test)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvContents.adapter = TestAdapter().apply {

            val list = mutableListOf<String>()
            for (i in 0 .. 20) {
                list.add(i.toString())
            }

            submitList(list)
        }
    }
}