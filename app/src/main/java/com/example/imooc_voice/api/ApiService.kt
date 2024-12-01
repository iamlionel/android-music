package com.example.imooc_voice.api

import com.example.imooc_voice.ui.mine.BannerResponse
import retrofit2.http.GET

interface ApiService {
    @GET("banner/json")
    suspend fun getBanner(): BannerResponse
}