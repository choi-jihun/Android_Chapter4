package com.example.chapter4_5.model

import java.util.Date

interface ListItem {
    val thumbnailUrl: String
    val dateTime: Date
    var isFavorite: Boolean
}