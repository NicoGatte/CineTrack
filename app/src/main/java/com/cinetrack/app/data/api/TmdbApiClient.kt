package com.cinetrack.app.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TmdbApiClient {
    const val API_KEY = "53eaf7037e2d966a857390cb0ea4df0c" // Placeholder
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        })
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiService: TmdbApiService by lazy {
        retrofit.create(TmdbApiService::class.java)
    }

    fun posterUrl(path: String?, size: String = "w500"): String? =
        path?.let { "$IMAGE_BASE_URL$size$it" }

    fun backdropUrl(path: String?, size: String = "w1280"): String? =
        path?.let { "$IMAGE_BASE_URL$size$it" }

    fun profileUrl(path: String?, size: String = "w185"): String? =
        path?.let { "$IMAGE_BASE_URL$size$it" }
        
    fun logoUrl(path: String?, size: String = "w92"): String? =
        path?.let { "$IMAGE_BASE_URL$size$it" }
}
