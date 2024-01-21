package org.example.job_posting_service.screen.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import org.example.job_posting_service.screen.MainScreen
import org.example.job_posting_service.screen.auth.IdentificationScreen
import root.Root
import root.RootComponent

@Composable
fun RootScreen(component: RootComponent) {
  Children(
    stack = component.childStack,
    animation = stackAnimation(slide()),
  ) {
    when (val child = it.instance) {
      is Root.Child.Identification -> IdentificationScreen(child.component)
      is Root.Child.Main -> MainScreen(child.component)
    }
  }
}
