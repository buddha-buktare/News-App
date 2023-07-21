package me.buddha.news.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.buddha.news.R.color

@Composable
fun SubscriptionItem(
  onClick: () -> Unit,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        horizontal = 10.dp,
        vertical = 6.dp,
      )
      .height(120.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(color = colorResource(id = color.grey))
      .clickable { onClick() },
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    Text(
      text = "Subscribe Now!",
      modifier = Modifier.padding(end = 8.dp),
      fontSize = 40.sp,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      fontFamily = FontFamily.SansSerif,
      color = colorResource(id = color.white),
      textAlign = TextAlign.Center
    )
  }
}
