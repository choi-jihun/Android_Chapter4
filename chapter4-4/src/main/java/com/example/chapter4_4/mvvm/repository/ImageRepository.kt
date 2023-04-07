package com.example.chapter4_4.mvvm.repository

import com.example.chapter4_4.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {
    fun getRandomImage(): Single<Image>
}