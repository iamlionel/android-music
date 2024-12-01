package com.example.lib_network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LogInterceptor(private val tag: String = "HTTP") : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val startTime = System.currentTimeMillis()

        // Print request
        val requestMessage = StringBuilder().apply {
            appendLine("-->")
            appendLine("Method: ${request.method}")
            appendLine("URL: ${request.url}")
            append("Headers: ")
            request.headers.forEach { (name, value) ->
                append("$name: $value  ")
            }
            appendLine()
        }.toString()
        Log.d(tag, requestMessage)

        // Send request and get response
        val response = chain.proceed(request)
        val duration = System.currentTimeMillis() - startTime

        // Print response
        val responseMessage = StringBuilder().apply {
            appendLine("<--")
            appendLine("Time: ${duration}ms")
            appendLine("Code: ${response.code}")
            append("Headers: ")
            response.headers.forEach { (name, value) ->
                append("$name: $value  ")
            }
            appendLine()
            appendLine("----------")
        }.toString()
        Log.d(tag, responseMessage)

        return response
    }
}