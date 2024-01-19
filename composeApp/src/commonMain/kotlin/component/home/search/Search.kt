package component.home.search

import kotlinx.coroutines.flow.StateFlow

interface Search {
  val searchText: StateFlow<String>

  fun onSearchTextChange(searchText: String)

  fun onSearchClick()
}
