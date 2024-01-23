import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import java.awt.Dimension
import root.RootComponent
import screens.RootScreen
import theme.APPLICATION_TITLE
import ui.theme.WINDOW_MIN_HEIGHT
import ui.theme.WINDOW_MIN_WIDTH
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
      state = rememberWindowState(size = DpSize(1200.dp, 800.dp)),
    ) {
      window.minimumSize = Dimension(WINDOW_MIN_WIDTH, WINDOW_MIN_HEIGHT)
      RootScreen(root)
    }
  }
}

@Preview
@Composable
fun appDesktopPreview() {
  App()
}
