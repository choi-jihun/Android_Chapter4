package com.example.chapter4_7.repository

import com.example.chapter4_7.data.dao.ContentDao
import com.example.chapter4_7.model.ContentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ContentRepositoryImpl @Inject constructor(private val contentDao: ContentDao): ContentRepository {
    override fun loadList() = contentDao.selectAll()

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }

    override suspend fun modify(item: ContentEntity) {
        contentDao.insert(item) //충돌이 발생할 경우 ContentDao의 onConflict = OnConflictStrategy.REPLACE에서 덮어쓰기 때문에 insert함수만 써도 됨
    }

    override suspend fun delete(item: ContentEntity) {
        contentDao.delete(item)
    }
}