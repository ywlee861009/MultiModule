package com.example.multimodule.presentation.main.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.multimodule.domain.entity.GithubEntity
import com.example.multimodule.presentation.databinding.ItemRowBinding

/**
 * github holder
 */
class GithubHolder(
    private val binding: ItemRowBinding
): RecyclerView.ViewHolder(binding.root) {
    init {
        binding.layoutRoot.setOnClickListener {

        }
    }

    fun bind(data: GithubEntity) {
        binding.tvName.text = data.name
        binding.tvId.text = data.id
        binding.tvDate.text = data.date
        binding.tvUrl.text = data.url
    }
}