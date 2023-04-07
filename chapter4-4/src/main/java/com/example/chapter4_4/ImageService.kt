package com.example.chapter4_4

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID kIVfotg4V9StS1m-WJwRjbvX7JJY61nGVAjpSq7E8T0")
    @GET("/photos/random")
    fun getRandomImage() : Call<ImageResponse>

    @Headers("Authorization: Client-ID kIVfotg4V9StS1m-WJwRjbvX7JJY61nGVAjpSq7E8T0")
    @GET("/photos/random")
    fun getRandomImageRx() : Single<ImageResponse>

    @Headers("Authorization: Client-ID kIVfotg4V9StS1m-WJwRjbvX7JJY61nGVAjpSq7E8T0")
    @GET("/photos/random")
    suspend fun getRandomImageSuspend() : ImageResponse
}