package me.buddha.news.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import me.buddha.news.R
import me.buddha.news.R.color

@Composable
fun NewsDetailsScreen(
  viewModel: MainViewModel,
  navController: NavController,
) {

  var startAnim by remember {
    mutableStateOf(false)
  }

  LaunchedEffect(Unit) {
    delay(300)
    startAnim = true
  }

  viewModel.selectedNews?.let { news ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    ) {

      Box(
        modifier = Modifier
          .clip(CircleShape)
          .background(color = colorResource(id = R.color.grey))
          .size(64.dp)
          .clickable {
            navController.popBackStack()
          },
        contentAlignment = Alignment.Center,
      ) {
        Icon(
          painter = painterResource(id = R.drawable.ic_back),
          contentDescription = null,
          modifier = Modifier.size(36.dp),
          tint = colorResource(id = R.color.white)
        )
      }

      Spacer(modifier = Modifier.height(8.dp))

      Column(
        modifier = Modifier
          .fillMaxSize()
          .clip(RoundedCornerShape(16.dp))
          .background(color = colorResource(id = R.color.grey))
      ) {
        AnimatedVisibility(
          visible = startAnim,
          enter = fadeIn(initialAlpha = 0.25f),
          modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp, 250.dp),
        ) {

          AsyncImage(
            model = news.urlToImage ?: R.drawable.placeholder,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = news.title,
          modifier = Modifier.padding(horizontal = 8.dp),
          fontSize = 20.sp,
          fontFamily = FontFamily.SansSerif,
          color = colorResource(id = color.white),
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
          text = news.description ?: "",
          modifier = Modifier
            .padding(horizontal = 8.dp)
            .alpha(0.5f),
          fontSize = 15.sp,
          fontFamily = FontFamily.SansSerif,
          color = colorResource(id = color.white),
        )
      }
    }
  }
}