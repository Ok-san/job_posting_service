package org.example.job_posting_service

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import org.example.job_posting_service.screen.navigation.RootScreen
import org.example.job_posting_service.ui.theme.Job_posting_serviceTheme
import root.RootComponent


class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val rootComponent = RootComponent(defaultComponentContext())

    setContent {
      Job_posting_serviceTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background,
        ) {
          RootScreen(rootComponent)
        }
      }
    }
  }
}
