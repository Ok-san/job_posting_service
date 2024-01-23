package org.example.job_posting_service.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import org.example.job_posting_service.screen.home.HomeScreen
import org.example.job_posting_service.screen.navigation.BottomNavigationBar
import org.example.job_posting_service.screen.profile.ViewableProfileScreen
import page.main.MainPage

@Composable
fun MainScreen(component: MainPage) {
  Scaffold(
    bottomBar = {
      BottomNavigationBar(
        onClick = component::onTabClick,
      )
    },
    content = { padding ->
      Box(modifier = Modifier.padding(padding)) {
        Children(
          stack = component.childStack,
          animation = stackAnimation(slide()),
        ) {
          when (val child = it.instance) {
            is MainPage.Child.Home -> HomeScreen(child.component)
            is MainPage.Child.Favorites -> FavoritesScreen()
//            is MainPage.Child.Profile -> ProfileScreen()
            is MainPage.Child.Profile -> ViewableProfileScreen()
          }
        }
      }
    },
  )
}
