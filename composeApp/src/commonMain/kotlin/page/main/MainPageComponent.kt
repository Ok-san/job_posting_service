package page.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import page.main.favorites.FavoritesPageComponent
import page.main.home.HomePageComponent
import page.main.profile.ProfilePageComponent

class MainPageComponent(
    context: ComponentContext,
) : MainPage, ComponentContext by context {
    private val navigate = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, MainPage.Child>> =
        childStack(
            source = navigate,
            initialConfiguration = Config.HomePageConfig,
            serializer = Config.serializer(),
            handleBackButton = true,
            childFactory = ::child
        )

//    private fun Config.toTab(): MainPage.Tab =
//        when(this){
//            Config.FavoritesPageConfig -> MainPage.Tab.Favorites
//            Config.HomePageConfig -> MainPage.Tab.Home
//            Config.ProfilePageConfig -> MainPage.Tab.Profile
//        }

    override fun onTabClick(tab: MainPage.Tab) {
        when (tab) {
            MainPage.Tab.Home -> navigate.bringToFront(Config.HomePageConfig)
            MainPage.Tab.Favorites -> navigate.bringToFront(Config.FavoritesPageConfig)
            MainPage.Tab.Profile -> navigate.bringToFront(Config.ProfilePageConfig)
        }
    }

    private fun child(config: Config, context: ComponentContext): MainPage.Child =
        when (config) {
            is Config.HomePageConfig -> MainPage.Child.Home(HomePageComponent(context))
            is Config.FavoritesPageConfig -> MainPage.Child.Favorites(FavoritesPageComponent(context))
            is Config.ProfilePageConfig -> MainPage.Child.Profile(ProfilePageComponent(context))
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object HomePageConfig : Config

        @Serializable
        data object FavoritesPageConfig : Config

        @Serializable
        data object ProfilePageConfig : Config

    }
}