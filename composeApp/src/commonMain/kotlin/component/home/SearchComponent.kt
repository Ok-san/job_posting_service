package component.home

import kotlinx.coroutines.flow.MutableStateFlow

class SearchComponent : Search {
    override val searchText = MutableStateFlow("")

    override fun onSearchTextChange(searchText: String) {
       this.searchText.value = searchText
    }

    override fun onSearchClick() {
        TODO("поиск по введеной строке")
    }
}