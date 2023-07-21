package me.buddha.news.domain.repository

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import me.buddha.news.data.network.PagingState
import me.buddha.news.data.network.service.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val service: ApiService
) {

  suspend fun getNews(page: Int) = flow {
    emit(PagingState.success(service.getNewsList(page)))
  }.catch {
    emit(PagingState.error(it))
  }
}