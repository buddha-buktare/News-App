package me.buddha.news.data.network

import me.buddha.news.data.model.Error
import me.buddha.news.data.network.response.NewsResponse

data class PagingState<out T>(
  val data: T? = null,
  val error: Error? = null,
  val isLoading: Boolean = false,
  val hasMorePages: Boolean = false,
) {
  companion object {

    fun <T> success(data: T): PagingState<T> {
      val pagingResponse = data as NewsResponse
      // return if(pagingResponse.news.size < pagingResponse.totalResults) {
      return PagingState(data = data, hasMorePages = true)
      // } else {
      //   PagingState(data = data, hasMorePages = false)
      // }
    }

    fun <T> loading(): PagingState<T> =
      PagingState(isLoading = true)

    fun <T> error(throwable: Throwable): PagingState<T> {
      return PagingState(
        error = Error(
          message = "Something went wrong! \n Please try again."
        )

      )
    }
  }
}