package screens

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import page.main.MainPage

@Composable
fun MainScreen(component: MainPage) {
   /* Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onClick = component::onTabClick
            )
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding))
            Children(
                stack = component.route,
                animation = stackAnimation(slide())
            ) {
                when (val child = it.instance) {
                    is MainPage.Child.Favorites -> FavoritesScreen()
                    is MainPage.Child.Home -> HomeScreen(child.component)
                    is MainPage.Child.Profile -> ProfileScreen()
                }

            }
        }
    )*/
}