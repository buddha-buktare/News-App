package me.buddha.news.data.network.response

import me.buddha.news.data.model.News

data class NewsResponse(
  val status: String,
  val totalResults: Int,
  val articles: List<News>,
)
