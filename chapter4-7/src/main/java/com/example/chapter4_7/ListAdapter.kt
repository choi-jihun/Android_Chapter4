package com.example.chapter4_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.chapter4_7.databinding.ItemContentBinding
import com.example.chapter4_7.model.ContentEntity

class ListAdapter(private val handler: MainActivity.Handler) :
    androidx.recyclerview.widget.ListAdapter<ContentEntity, ContentViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), handler
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}