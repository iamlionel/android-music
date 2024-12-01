package com.example.imooc_voice

import RetrofitManager
import android.app.Application
import com.example.lib_network.LogInterceptor
import net.lucode.hackware.magicindicator.BuildConfig
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        RetrofitManager.getInstance().updateConfig {
            baseUrl = "https://www.wanandroid.com/"
            connectTimeout = 30
            readTimeout = 30
            writeTimeout = 30

            if (BuildConfig.DEBUG) {
                addInterceptor(LogInterceptor())
            }

            addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer token")
                    .build()
                chain.proceed(request)
            }

            addConverterFactory(GsonConverterFactory.create())
        }
    }
}