package com.example.multimodule.feature.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.multimodule.feature.main.adapter.holder.GithubHolder
import com.example.multimodule.data.github.response.GithubResponse
import com.example.multimodule.R
import com.example.multimodule.domain.entity.GithubEntity

/**
 * Github repo adapter
 */
class GithubAdapter: ListAdapter<GithubEntity, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<GithubEntity>() {
    override fun areItemsTheSame(oldItem: GithubEntity, newItem: GithubEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GithubEntity, newItem: GithubEntity) =
        oldItem == newItem
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        GithubHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_row, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? GithubHolder)?.bind(getItem(position))
    }
}