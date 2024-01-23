package org.example.job_posting_service.screen.profile

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import page.main.profile.PersonalPage

@Composable
 fun PersonalScreen(component: PersonalPage) {
  Children(
    stack = component.childStack,
    animation = stackAnimation(slide()),
  ) {
    when (val child = it.instance) {
      is PersonalPage.Child.EditableProfileChild -> EditableProfileScreen(child.component)
      is PersonalPage.Child.ViewableProfileChild -> ViewableProfileScreen(child.component)
    }
  }
 }
