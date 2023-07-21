package me.buddha.news.domain

sealed class Destination (val route: String) {
  object NewsList: Destination("news_list")
  object NewsDetails: Destination("news_details")
}