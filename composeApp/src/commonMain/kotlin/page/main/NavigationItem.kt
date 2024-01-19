package page.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

class NavigationItem {
  constructor(title: String, tab: MainPage.Tab, icon: ImageVector) {
    this.title = title
    this.tab = tab
    this.icon = icon
  }

  var title: String
  var tab: MainPage.Tab
  var icon: ImageVector
}

val navigationBar: Array<NavigationItem> =
  arrayOf(
    NavigationItem("Home", MainPage.Tab.Home, Icons.Default.Home),
    NavigationItem("Favorites", MainPage.Tab.Favorites, Icons.Default.Favorite),
    NavigationItem("Profile", MainPage.Tab.Profile, Icons.Default.Person),
  )
