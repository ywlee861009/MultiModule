package com.example.multimodule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Github repo adapter
 */
class GithubAdapter: ListAdapter<GithubRepo, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<GithubRepo>() {
    override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo) =
        oldItem == newItem
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        GithubHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_row, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? GithubHolder)?.bind(getItem(position))
    }
}