package org.example.job_posting_service.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NotificationScreen() {
  Box(
    modifier =
      Modifier
        .fillMaxSize()
        .background(Color.Magenta),
    contentAlignment = Alignment.Center,
  ) {
    Text(
      text = "Fav",
      fontSize = MaterialTheme.typography.headlineLarge.fontSize,
      fontWeight = FontWeight.Bold,
      color = Color.White,
    )
  }
}

@Composable
@Preview
fun NotificationScreenPreview() {
  NotificationScreen()
}
