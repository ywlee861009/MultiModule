package com.example.multimodule.presentation.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.multimodule.presentation.R
import com.example.multimodule.presentation.databinding.ItemRow1Binding
import com.example.multimodule.presentation.databinding.ItemRow2Binding

class TestAdapter: ListAdapter<String, RecyclerView.ViewHolder>(
    object: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = (oldItem.hashCode() == newItem.hashCode())
        override fun areContentsTheSame(oldItem: String, newItem: String) = (oldItem == newItem)
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> Test2Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_row_2, parent, false))
            else -> Test1Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_row_1, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Test1Holder -> {
                holder.bind(getItem(position))
            }

            is Test2Holder -> {
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 2)
            0
        else
            1
    }

    inner class Test1Holder(private val binding: ItemRow1Binding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.tvTest.setOnClickListener {

            }
        }

        fun bind(data: String) {
            binding.tvTest.text = String.format("Android Test %s", data)

            try {
                val test = data.toInt()
                if (test % 2 == 0) {
                    binding.layoutRoot.setBackgroundResource(R.color.white)
                } else {
                    binding.layoutRoot.setBackgroundResource(R.color.gray)
                }
            } catch (e: Exception) {
                //
            }
        }
    }

    inner class Test2Holder(private val binding: ItemRow2Binding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {

            binding.tvData.text = "test test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test testtest test test test"
        }
    }
}