package com.example.chapter4_7.repository

import com.example.chapter4_7.model.ContentEntity

interface ContentRepository {

    suspend fun insert(item: ContentEntity)
}