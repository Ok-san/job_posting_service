package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import page.identification.IdentificationPageComponent
import page.main.MainPageComponent

class RootComponent(
    componentContext: ComponentContext,
) : Root, ComponentContext by componentContext {

    private val navigate = StackNavigation<Config>()

    override val route: Value<ChildStack<*, Root.Child>> =
        childStack(
            source = navigate,
            serializer = Config.serializer(),
            initialConfiguration = Config.IdentificationScreenConfig,
            childFactory = ::child
        )

    private fun child(config: Config, context: ComponentContext): Root.Child =
        when (config) {
            is Config.IdentificationScreenConfig -> Root.Child.Identification(
                IdentificationPageComponent(
                    context = context,
                    onSignIn = { navigate.replaceAll(Config.MainScreenConfig) },
                )
            )

            is Config.MainScreenConfig -> Root.Child.Main(MainPageComponent(context = context))
        }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object IdentificationScreenConfig : Config

        @Serializable
        data object MainScreenConfig : Config
    }
}