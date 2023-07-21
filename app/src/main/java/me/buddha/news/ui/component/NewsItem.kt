package me.buddha.news.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import me.buddha.news.R
import me.buddha.news.data.model.News

@Composable
internal fun NewsItem(
  news: News,
  onClick: () -> Unit,
) {
  Box(
    modifier = Modifier.fillMaxSize()
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
        .background(color = colorResource(id = R.color.grey))
        .clickable { onClick() },
      verticalAlignment = Alignment.CenterVertically,
    ) {

      AsyncImage(
        model = news.urlToImage ?: R.drawable.placeholder,
        contentDescription = null,
        modifier = Modifier
          .widthIn(0.dp, 120.dp)
          .fillMaxHeight(),
        contentScale = ContentScale.FillBounds,
      )
      Spacer(modifier = Modifier.width(16.dp))
      Text(
        text = news.title,
        modifier = Modifier.padding(end = 8.dp),
        fontSize = 10.sp,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily.SansSerif,
        color = colorResource(id = R.color.white),
      )
    }
  }
}