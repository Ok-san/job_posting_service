package page.main.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import component.home.orderlist.OrderDetailsComponent
import component.home.orderlist.OrdersListComponent
import kotlinx.serialization.Serializable
import network.DefaultDatabase

class HomePageComponent(
  componentContext: ComponentContext,
) : ComponentContext by componentContext, HomePage {
  private val database = DefaultDatabase()
  private val navigate = StackNavigation<Config>()

  override val childStack: Value<ChildStack<*, HomePage.Child>> =
    childStack(
      source = navigate,
      serializer = Config.serializer(),
      handleBackButton = true,
      initialConfiguration = Config.List,
      childFactory = ::child,
    )

  private fun child(
    config: Config,
    componentContext: ComponentContext,
  ): HomePage.Child =
    when (config) {
      is Config.Details -> {
        HomePage.Child.OrderDetailsChild(
          OrderDetailsComponent(
            componentContext = componentContext,
            orderId = config.id,
            onBack = { navigate.pop() },
            database = database,
          ),
        )
      }

      Config.List -> {
        HomePage.Child.OrderListChild(
          OrdersListComponent(
            componentContext = componentContext,
            database = database,
            onSelected = { id -> navigate.push(Config.Details(id)) },
          ),
        )
      }
    }

  @Serializable
  private sealed interface Config {
    @Serializable
    data object List : Config

    @Serializable
    data class Details(val id: Int) : Config
  }
}
