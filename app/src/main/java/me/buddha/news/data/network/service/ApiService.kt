package me.buddha.news.data.network.service

import me.buddha.news.data.network.response.NewsResponse
import me.buddha.news.domain.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("v2/top-headlines")
  suspend fun getNewsList(
    @Query("page") page: Int,
    @Query("apiKey") apiKey: String = API_KEY,
    @Query("country") country: String = "in",
  ): NewsResponse

}