package me.buddha.news.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.buddha.news.R.color
import me.buddha.news.domain.Destination.NewsDetails
import me.buddha.news.domain.extention.OnEndReached
import me.buddha.news.ui.component.NewsItem
import me.buddha.news.ui.component.SubscriptionItem

@Composable
fun NewsListSuccessState(
  viewModel: MainViewModel,
  navController: NavHostController,
) {

  val state = rememberLazyListState()
  val context = LocalContext.current

  Column(
    modifier = Modifier.fillMaxSize(),
  ) {

    Text(
      text = "News App",
      modifier = Modifier
        .fillMaxWidth()
        .padding(end = 8.dp),
      textAlign = TextAlign.Center,
      fontSize = 50.sp,
      fontFamily = FontFamily.SansSerif,
      fontWeight = FontWeight.Bold,
      color = colorResource(id = color.white),
    )

    Spacer(modifier = Modifier.height(10.dp))

    LazyColumn(
      state = state,
      modifier = Modifier.fillMaxSize(),
    ) {

      itemsIndexed(viewModel.news) { index, news ->
        NewsItem(
          news = news,
          onClick = {
            viewModel.selectedNews = news
            navController.navigate(NewsDetails.route)
          },
        )

        if (index % 3 == 0) {
          SubscriptionItem(
            onClick = {
              Toast.makeText(
                context,
                "Congratulations! You have successfully Subscribed.",
                Toast.LENGTH_LONG
              ).show()
            }
          )
        }

      }
    }
  }

  state.OnEndReached {
    viewModel.fetchNews()
  }
}