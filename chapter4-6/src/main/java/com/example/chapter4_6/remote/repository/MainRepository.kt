package com.example.chapter4_6.remote.repository

import androidx.paging.PagingData
import com.example.chapter4_6.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}