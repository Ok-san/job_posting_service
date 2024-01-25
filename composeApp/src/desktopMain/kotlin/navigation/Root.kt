package navigation

import androidx.compose.runtime.Composable
import auth.IdentificationScreen
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import root.Root
import root.RootComponent
import screens.MainScreen

@Composable
fun RootScreen(rootComponent: RootComponent) {
  Children(
    stack = rootComponent.childStack,
    animation = stackAnimation(slide()),
  ) {
    when (val child = it.instance) {
      is Root.Child.Identification -> IdentificationScreen(child.component)
      is Root.Child.Main -> MainScreen(child.component)
    }
  }
}
