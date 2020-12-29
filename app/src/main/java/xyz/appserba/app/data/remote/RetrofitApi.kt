package xyz.appserba.app.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApi {
    const val BASE_URL = "https://api.kawalcorona.com/"

    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    private fun create(url: String): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    fun newsService(): AttributesService {
        return create(BASE_URL).create(AttributesService::class.java)
    }
}