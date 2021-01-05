package easygautam.networking

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

abstract class EGBaseNetwork {

    val retrofit: Retrofit

    abstract val baseUrl: String

    abstract fun interceptors(): List<Interceptor>

    abstract fun authenticator(): Authenticator?

    var allowDebug: Boolean = false


    init {
        retrofit = buildRetrofit()
    }

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(buildClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private fun buildClient() = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor())
        .apply {

            interceptors().forEach {
                addInterceptor(it)
            }

            authenticator()?.let {
                authenticator(it)
            }

        }
        .build()

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        if (allowDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }


    inline fun <reified T> createService() = this.retrofit.create<T>()
}