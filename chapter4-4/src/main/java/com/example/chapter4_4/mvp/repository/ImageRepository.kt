package com.example.chapter4_4.mvp.repositor

interface ImageRepository {

    fun getRandomImage(callback: CallBack)

    interface CallBack {
        fun loadImage(url: String, color: String)
    }
}