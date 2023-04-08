package com.example.chapter4_5.list

import com.example.chapter4_5.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem)
}