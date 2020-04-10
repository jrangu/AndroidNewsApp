package com.smartphone.topnews.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://newsapi.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


/**
 * A public interface that exposes the [getProperties] method
 */
interface TopNewsApiService {
    @GET("/v2/top-headlines")
    fun getProperties(
        @Query("country") country: String, @Query("category") category: String, @Query(
            "apiKey"
        ) apiKey: String
    ):
            Call<NewsProperty>
}


object TopNewsApi {
    val retrofitService: TopNewsApiService by lazy {
        retrofit.create(TopNewsApiService::class.java)
    }

}


