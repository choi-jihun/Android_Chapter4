package com.example.chapter4_5

import com.example.chapter4_5.model.ImageListResponse
import com.example.chapter4_5.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaAK d9fefb421e3f33082ff26093897f9f80")
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @Headers("Authorization: KakaAK d9fefb421e3f33082ff26093897f9f80")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>
}