import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import root.RootComponent
import screens.RootScreen
import theme.APPLICATION_TITLE
import utils.runOnUiThread

// fun FrameWindowScope.setMinSize() {
//    window.minimumSize = Dimension(windowMinWidth, windowMinHeight)
// }

fun main() {
  val lifecycle = LifecycleRegistry()
  val root =
    runOnUiThread {
      RootComponent(componentContext = DefaultComponentContext(lifecycle = lifecycle))
    }

  application {
    Window(
      title = APPLICATION_TITLE,
      icon = painterResource("drawable/logo.png"),
      focusable = true,
      onCloseRequest = ::exitApplication,
//            state = rememberWindowState(size = DpSize(850.dp, 650.dp)),
    ) {
      RootScreen(root)
    }
  }
}

@Preview
@Composable
fun appDesktopPreview() {
  App()
}
