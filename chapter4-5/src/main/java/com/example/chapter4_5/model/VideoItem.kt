package com.example.chapter4_5.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class VideoListResponse(
    val documents: List<VideoItem>
)

data class VideoItem(
    @SerializedName("thumbnail")
    override val thumbnailUrl: String,
    val title: String,
    @SerializedName("play_time")
    var playTime: Int,
    val author: String,
    @SerializedName("datetime")
    override val dateTime: Date,
    override var isFavorite: Boolean = false
): ListItem
