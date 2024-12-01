package com.example.imooc_voice.repository

import RetrofitManager
import com.example.imooc_voice.api.ApiService
import com.example.lib_network.safeApiCall

class Repository {
    private val apiService = RetrofitManager.getInstance().getService(ApiService::class.java)

    suspend fun getBanner() = safeApiCall {
        apiService.getBanner()
    }
}