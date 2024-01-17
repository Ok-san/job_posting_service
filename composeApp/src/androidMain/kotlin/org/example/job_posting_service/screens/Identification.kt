package org.example.job_posting_service.screens

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import page.identification.IdentificationPage

@Composable
fun IdentificationScreen(component: IdentificationPage) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(slide())
    ) {
        when (val child = it.instance) {
            is IdentificationPage.Child.RegistrationChild -> RegistrationScreen(child.component)
            is IdentificationPage.Child.AuthorizationChild -> AuthorizationScreen(child.component)
        }
    }
}