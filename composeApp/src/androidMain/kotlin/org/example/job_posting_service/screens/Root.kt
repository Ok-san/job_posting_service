package org.example.job_posting_service.screens

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import root.Root
import root.RootComponent

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
