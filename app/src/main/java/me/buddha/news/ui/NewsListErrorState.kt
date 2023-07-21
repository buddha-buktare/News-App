package me.buddha.news.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.buddha.news.R

@Composable
fun NewsListErrorState(
  errorTitle: String,
  onRetryClick: () -> Unit,
) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {

    Column(
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = errorTitle,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        color = colorResource(id = R.color.white),
        textAlign = TextAlign.Center
      )
      Spacer(modifier = Modifier.height(40.dp))
      Button(
        onClick = onRetryClick,
        colors = ButtonDefaults.buttonColors(
          containerColor = colorResource(id = R.color.grey),
        )
      ) {
        Text(
          text = "Retry",
          fontSize = 25.sp,
          fontFamily = FontFamily.SansSerif,
          color = colorResource(id = R.color.white),
          textAlign = TextAlign.Center
        )
      }
    }
  }
}