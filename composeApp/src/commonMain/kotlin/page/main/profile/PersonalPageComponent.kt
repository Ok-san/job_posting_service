package page.main.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import component.profile.EditableProfileIComponent
import component.profile.ViewableProfileComponent
import kotlinx.serialization.Serializable
import network.DefaultDatabase

class PersonalPageComponent(
  context: ComponentContext,
  private val userId: Int,
  private val database: DefaultDatabase,
) : PersonalPage, ComponentContext by context {
  private val navigate = StackNavigation<Config>()
  override val childStack: Value<ChildStack<*, PersonalPage.Child>> =
    childStack(
      source = navigate,
      serializer = Config.serializer(),
      initialConfiguration = Config.ViewableConfig,
      childFactory = ::child,
    )

  private fun child(
    config: Config,
    context: ComponentContext,
  ): PersonalPage.Child =
    when (config) {
      is Config.ViewableConfig ->
        PersonalPage.Child.ViewableProfileChild(
          ViewableProfileComponent(
            context = context,
            database = database,
            userId = userId,
            onLogOut = { navigate.popTo(1) },
            onEdit = { navigate.push(Config.EditableConfig) },
          ),
        )

      is Config.EditableConfig ->
        PersonalPage.Child.EditableProfileChild(
          EditableProfileIComponent(
            context = context,
            database = database,
            userId = userId,
            onBack = { navigate.pop() },
          ),
        )
    }

  @Serializable
  private sealed interface Config {
    @Serializable
    data object ViewableConfig : Config

    @Serializable
    data object EditableConfig : Config
  }
}
