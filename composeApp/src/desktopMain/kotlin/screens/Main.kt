package screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import home.HomeScreen
import navigation.NavigationBar
import org.example.job_posting_service.screen.profile.PersonalScreen
import page.main.MainPage
import ui.theme.navigationBarSize

@Composable
fun MainScreen(component: MainPage) {
  Scaffold(
    bottomBar = {
      NavigationBar(
        onClick = component::onTabClick,
      )
    },
    content = {
      Children(
        modifier = Modifier.padding(start = navigationBarSize),
        stack = component.childStack,
        animation = stackAnimation(slide()),
      ) {
        when (val child = it.instance) {
          is MainPage.Child.Home -> HomeScreen(child.component)
          is MainPage.Child.Favorites -> FavoritesScreen()
          is MainPage.Child.Profile -> PersonalScreen(child.component)
        }
      }
    },
  )
}
