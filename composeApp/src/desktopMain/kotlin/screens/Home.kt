package screens

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import org.example.job_posting_service.screens.OrderDetailsScreen
import org.example.job_posting_service.screens.OrdersListScreen
import page.main.home.HomePage

@Composable
fun HomeScreen(component: HomePage) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(slide())
    ) {
        when (val child = it.instance) {
            is HomePage.Child.OrderListChild -> OrdersListScreen(component = child.component)
            is HomePage.Child.OrderDetailsChild -> OrderDetailsScreen(component = child.component)
        }
    }
}
