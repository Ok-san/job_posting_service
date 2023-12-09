package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import kotlinx.serialization.serializer

class RootComponent(
    context: ComponentContext, override val router: Value<ChildStack<*, Root.Child>>,
) : Root, ComponentContext by context {
    private val navigator = StackNavigation<Config>()

    @Serializable
    private sealed interface Config {
        @Serializable
        data class StartChildConfig(val index: Int) : Config
    }

    override fun onNext() {
        navigator.push(Config.StartChildConfig(index = router.value.backStack.size + 1))
    }

    override fun onPrev() {
        TODO("Not yet implemented")
    }
}