package com.example.chapter4_5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4_5.databinding.ItemVideoBinding
import com.example.chapter4_5.list.ItemHandler
import com.example.chapter4_5.model.ListItem
import com.example.chapter4_5.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }
}