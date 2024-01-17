package page.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import page.main.favorites.FavoritesPage
import page.main.home.HomePage
import page.main.profile.ProfilePage

interface MainPage {
    val childStack: Value<ChildStack<*, Child>>

    fun onTabClick(tab: Tab)

    enum class Tab {
        Home, Favorites, Profile
    }

    sealed class Child {
        class Home(val component: HomePage) : Child()
        class Favorites(val component: FavoritesPage) : Child()
        class Profile(val component: ProfilePage) : Child()
    }
}