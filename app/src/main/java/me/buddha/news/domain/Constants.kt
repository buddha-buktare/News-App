package me.buddha.news.domain

class Constants {
  companion object {
    const val BASE_URL = "https://newsapi.org/"
    const val API_KEY = "b1a513248b9c4e7c95c67f66634ea818"
  }
}

sealed class ScreenState(val errorMessage: String? = null) {
  object Success : ScreenState()
  data class Error(val message: String? = null) : ScreenState(errorMessage = message)
  object Loading : ScreenState()
}