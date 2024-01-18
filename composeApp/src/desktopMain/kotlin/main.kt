
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import root.RootComponent
import screens.RootScreen
import theme.applicationTitle
import utils.runOnUiThread

fun main() {
    val lifecycle = LifecycleRegistry()
    val root = runOnUiThread {
        RootComponent(componentContext = DefaultComponentContext(lifecycle = lifecycle))
    }

    application {
        Window(
            title = applicationTitle,
            icon = painterResource("drawable/logo.png"),
            focusable = true,
            onCloseRequest = ::exitApplication
        ) {
//            HomeScreen()

            RootScreen(root)
//            App()
//            App(component = root)
        }
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}