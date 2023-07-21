package me.buddha.news.domain.extention

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow

const val PAGE_LIMIT = 20

@Composable
fun LazyListState.OnEndReached(onLoadMore: () -> Unit) {
  val shouldLoadMore = remember {
    derivedStateOf {
      val totalItemsNumber = layoutInfo.totalItemsCount
      val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
      lastVisibleItemIndex > totalItemsNumber - 2
    }
  }

  LaunchedEffect(Unit) {
    snapshotFlow { shouldLoadMore.value }
      .collect { value ->
        if (value) {
          onLoadMore()
        }
      }
  }
}

fun <T> MutableList<T>.addPageData(list: List<T>) {
  this.addAll(list)
  val distinctList = this.distinctBy { it.hashCode() }
  this.clear()
  this.addAll(distinctList)
}

fun <T> MutableList<T>.getNextPageNumber(): Int =
  this.size / PAGE_LIMIT + 1
