package page.main.favorites

import com.arkivanov.decompose.ComponentContext
import network.DefaultDatabase

class FavoritesPageComponent(
  context: ComponentContext,
  private val userId: Int,
  private val database: DefaultDatabase,
) : FavoritesPage, ComponentContext by context {
  override fun onItemClick() {
    TODO("Not yet implemented")
  }

  override fun onHeartClick() {
    TODO("Not yet implemented")
  }
}
