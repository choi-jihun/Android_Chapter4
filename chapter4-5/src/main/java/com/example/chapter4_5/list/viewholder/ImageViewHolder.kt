package com.example.chapter4_5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter4_5.databinding.ItemImageBinding
import com.example.chapter4_5.list.ItemHandler
import com.example.chapter4_5.model.ImageItem
import com.example.chapter4_5.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding,
    private val itemHandler: ItemHandler ?= null
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ListItem) {
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }
}