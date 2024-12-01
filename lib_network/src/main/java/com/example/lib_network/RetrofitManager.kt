import com.example.lib_network.RetrofitConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

class RetrofitManager private constructor() {
    private var retrofitClient: Retrofit? = null
    private var clientConfig = RetrofitConfig()
    private val serviceMap = ConcurrentHashMap<Class<*>, Any>()

    fun updateConfig(config: RetrofitConfig.() -> Unit) {
        clientConfig.apply(config)
        // 更新配置后重新创建 Retrofit 实例
        retrofitClient = buildRetrofit()
        // 清空已创建的service实例，以便重新创建
        serviceMap.clear()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getService(serviceClass: Class<T>): T {
        return serviceMap.getOrPut(serviceClass) {
            requireNotNull(retrofitClient) { "RetrofitClient not initialized" }
            retrofitClient!!.create(serviceClass)
        } as T
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(clientConfig.baseUrl)
            .client(buildOkHttpClient())
            .apply {
                clientConfig.converterFactories.forEach { addConverterFactory(it) }
                clientConfig.callAdapterFactories.forEach { addCallAdapterFactory(it) }
            }
            .build()
    }

    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(clientConfig.connectTimeout, TimeUnit.SECONDS)
            readTimeout(clientConfig.readTimeout, TimeUnit.SECONDS)
            writeTimeout(clientConfig.writeTimeout, TimeUnit.SECONDS)
            retryOnConnectionFailure(clientConfig.retryOnConnectionFailure)
            clientConfig.interceptors.forEach { addInterceptor(it) }
        }.build()
    }

    companion object {
        @Volatile
        private var instance: RetrofitManager? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: RetrofitManager().also { instance = it }
        }
    }
}

