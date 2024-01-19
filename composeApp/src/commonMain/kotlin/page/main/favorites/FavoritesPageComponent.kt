package page.main.favorites

import com.arkivanov.decompose.ComponentContext

class FavoritesPageComponent(context: ComponentContext) :
  FavoritesPage,
  ComponentContext by context {
  override fun onItemClick() {
    TODO("Not yet implemented")
  }

  override fun onHeartClick() {
    TODO("Not yet implemented")
  }
}
