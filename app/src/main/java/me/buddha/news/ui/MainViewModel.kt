package me.buddha.news.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import me.buddha.news.data.model.News
import me.buddha.news.domain.ScreenState
import me.buddha.news.domain.extention.addPageData
import me.buddha.news.domain.extention.getNextPageNumber
import me.buddha.news.domain.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository: MainRepository
) : ViewModel() {

  val news = mutableStateListOf<News>()
  var selectedNews by mutableStateOf<News?>(null)
  var screenState by mutableStateOf<ScreenState>(ScreenState.Loading)
  private var hasMorePages by mutableStateOf(true)

  fun fetchNews() {
    if (hasMorePages) {
      viewModelScope.launch {
        repository.getNews(news.getNextPageNumber()).onEach { pagingState ->
          pagingState.data?.articles?.let {
            news.addPageData(it.toMutableStateList())
            screenState = ScreenState.Success

            hasMorePages = pagingState.hasMorePages
          }
          pagingState.error?.let {
            if (news.isEmpty()) {
              screenState = ScreenState.Error(it.message)
            }
          }
        }.launchIn(viewModelScope)
      }
    }
  }
}