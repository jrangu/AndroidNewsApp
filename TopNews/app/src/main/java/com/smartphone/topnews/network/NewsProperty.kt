package com.smartphone.topnews.network

import com.squareup.moshi.Json

data class NewsProperty(
    @Json(name = "articles") val newsDetails: List<NewsArticles>?
)

data class NewsArticles(
    val author: String?,
    val title: String?,
    val publishedAt: String?,
    val content: String?,
    val urlToImage: String?
)