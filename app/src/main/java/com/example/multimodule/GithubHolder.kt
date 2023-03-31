package com.example.multimodule

import androidx.recyclerview.widget.RecyclerView
import com.example.multimodule.databinding.ItemRowBinding

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

    fun bind(data: GithubRepo) {
        binding.tvName.text = data.name
        binding.tvId.text = data.id
        binding.tvDate.text = data.date
        binding.tvUrl.text = data.url
    }
}