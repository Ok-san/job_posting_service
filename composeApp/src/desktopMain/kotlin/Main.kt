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
import migrations.Categories
import navigation.RootScreen
import root.RootComponent
import theme.APPLICATION_TITLE
import ui.theme.WINDOW_MIN_HEIGHT
import ui.theme.WINDOW_MIN_WIDTH
import utils.runOnUiThread

fun main() {
  val lifecycle = LifecycleRegistry()
  val root =
    runOnUiThread {
      RootComponent(componentContext = DefaultComponentContext(lifecycle = lifecycle))
    }

  val driver = DriverFactory()
  val db = createDatabase(driver)
  val orderQueries = db.orderQueries
  val categoryQueries = db.categoryQueries

  categoryQueries.insertCategory(null, "Строительство")
  categoryQueries.insertCategory(null, "Ремонт")

  orderQueries.insertArchivedOrder(null, "aboba", 0, "Надо построить мне будку", 11, 12, "Хочу огромную двухэтажную будку с подогревом сеном и миской", 0, "Бокситогорск")
  orderQueries.insertArchivedOrder(null, "Илья", 1, "разбили ночник", 11, 12, "Шёл вечером по улице а там два макаровца ну и ...", 1000, "Спб")

  val CategoryStorage: List<Categories> = db.categoryQueries.getAllCategories().executeAsList()
  val OrderStorage = db.orderQueries.getArchivedOrdersByUser("Илья").executeAsList()

  println(CategoryStorage)
  println(OrderStorage)

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
