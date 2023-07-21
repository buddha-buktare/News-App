package me.buddha.news.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.buddha.news.R
import me.buddha.news.domain.Destination
import me.buddha.news.ui.theme.NewsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val viewModel by viewModels<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      NewsTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = colorResource(id = R.color.dark_grey)
        ) {

          val navController = rememberNavController()
          NavHost(
            navController = navController,
            startDestination = Destination.NewsList.route,
          ) {
            composable(Destination.NewsList.route) {
              NewsListScreen(
                viewModel = viewModel,
                navController = navController,
              )
            }

            composable(Destination.NewsDetails.route) {
              NewsDetailsScreen(
                viewModel = viewModel,
                navController = navController,
              )
            }
          }
        }
      }
    }
  }
}