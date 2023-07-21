package me.buddha.news.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import me.buddha.news.domain.ScreenState
import me.buddha.news.domain.ScreenState.Loading
import me.buddha.news.domain.ScreenState.Success

@Composable
internal fun NewsListScreen(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  LaunchedEffect(Unit) {
    delay(4500)
    viewModel.fetchNews()
  }

  when (val state = viewModel.screenState) {
    is ScreenState.Error -> NewsListErrorState(
      errorTitle = state.errorMessage ?: "Something went wrong! \n Please try again.",
      onRetryClick = viewModel::fetchNews
    )

    is Loading -> NewsListLoadingState()

    is Success -> NewsListSuccessState(
      viewModel = viewModel,
      navController = navController,
    )
  }
}