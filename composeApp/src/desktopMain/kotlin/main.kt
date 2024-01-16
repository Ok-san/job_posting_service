import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.example.job_posting_service.screens.AuthorizationScreen
import root.RootComponent
import utils.runOnUiThread

fun main() {
    val lifecycle = LifecycleRegistry()
    val root = runOnUiThread {
        RootComponent(componentContext = DefaultComponentContext(lifecycle = lifecycle))
    }

    application {
        Window(onCloseRequest = ::exitApplication) {
            AuthorizationScreen()
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