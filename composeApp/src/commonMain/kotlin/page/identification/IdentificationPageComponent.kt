package page.identification

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import component.identification.authorization.AuthorizationComponent
import component.identification.registration.RegistrationComponent
import kotlinx.serialization.Serializable
import network.DefaultDatabase

class IdentificationPageComponent(
  context: ComponentContext,
  private val database: DefaultDatabase,
  val onSignIn: (userId: Int?) -> Unit,
) : IdentificationPage, ComponentContext by context {
  private val navigate = StackNavigation<Config>()

  override val childStack: Value<ChildStack<*, IdentificationPage.Child>> =
    childStack(
      source = navigate,
      initialConfiguration = Config.AuthorizationConfig,
      serializer = Config.serializer(),
      handleBackButton = false,
      childFactory = ::child,
    )

  private fun child(
    config: Config,
    context: ComponentContext,
  ): IdentificationPage.Child =
    when (config) {
      is Config.AuthorizationConfig ->
        IdentificationPage.Child.AuthorizationChild(
          AuthorizationComponent(
            componentContext = context,
            onSignIn = onSignIn,
            onRegistration = { navigate.replaceAll(Config.RegistrationConfig) },
            database = database,
          ),
        )

      Config.RegistrationConfig ->
        IdentificationPage.Child.RegistrationChild(
          RegistrationComponent(
            componentContext = context,
            onSignIn = onSignIn,
            onAuthorization = { navigate.replaceAll(Config.AuthorizationConfig) },
            database = database,
          ),
        )
    }

  @Serializable
  private sealed interface Config {
    @Serializable
    data object AuthorizationConfig : Config

    @Serializable
    data object RegistrationConfig : Config
  }
}
