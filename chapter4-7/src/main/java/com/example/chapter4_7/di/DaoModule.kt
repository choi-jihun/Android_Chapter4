package com.example.chapter4_7.di

import com.example.chapter4_7.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}