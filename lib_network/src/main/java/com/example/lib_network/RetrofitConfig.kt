package com.example.lib_network

import okhttp3.Interceptor
import retrofit2.CallAdapter
import retrofit2.Converter

class RetrofitConfig {
    var baseUrl: String = ""
    var connectTimeout: Long = 30
    var readTimeout: Long = 30
    var writeTimeout: Long = 30
    var retryOnConnectionFailure: Boolean = true
    var interceptors: MutableList<Interceptor> = mutableListOf()
    var converterFactories: MutableList<Converter.Factory> = mutableListOf()
    var callAdapterFactories: MutableList<CallAdapter.Factory> = mutableListOf()

    fun addInterceptor(interceptor: Interceptor) {
        interceptors.add(interceptor)
    }

    fun addConverterFactory(factory: Converter.Factory) {
        converterFactories.add(factory)
    }

    fun addCallAdapterFactory(factory: CallAdapter.Factory) {
        callAdapterFactories.add(factory)
    }
}