package com.example.lib_network

import okio.IOException
import retrofit2.HttpException

sealed interface ApiResult<T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error<T>(val message: String) : ApiResult<T>
}

suspend fun <T> safeApiCall(call: suspend () -> T): ApiResult<T> = try {
    ApiResult.Success(call())
} catch (e: Exception) {
    ApiResult.Error(
        when (e) {
            is IOException -> e.message.toString()
            is HttpException -> "errorCode: ${e.code()}"
            else -> "unknown error: ${e.message}"
        }
    )
}
