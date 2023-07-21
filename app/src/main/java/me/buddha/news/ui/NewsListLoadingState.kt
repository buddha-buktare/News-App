package me.buddha.news.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import me.buddha.news.R

@Composable
fun NewsListLoadingState() {

  val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie))

  var isPlaying by remember { mutableStateOf(true) }
  var speed by remember { mutableStateOf(1f) }

  val progress by animateLottieCompositionAsState(
    composition,
    iterations = LottieConstants.IterateForever,
    isPlaying = isPlaying,
    speed = speed,
    restartOnPlay = false

  )
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    LottieAnimation(
      composition = composition,
      progress = progress,
      modifier = Modifier.size(400.dp)
    )
  }
}