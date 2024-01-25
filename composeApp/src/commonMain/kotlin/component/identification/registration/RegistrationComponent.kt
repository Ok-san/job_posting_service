package component.identification.registration

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import network.DefaultDatabase

class RegistrationComponent(
  componentContext: ComponentContext,
  val onSignIn: (userId: Int?) -> Unit,
  val onAuthorization: () -> Unit,
  private val database: DefaultDatabase,
) : Registration, ComponentContext by componentContext {
  override val name = MutableStateFlow("")
  override val login = MutableStateFlow("")
  override val password = MutableStateFlow("")
  override val inProgress = MutableStateFlow(false)

  override fun onLoginChanged(login: String) {
    this.login.value = login
  }

  override fun onPasswordChanged(password: String) {
    this.password.value = password
  }

  override fun onNameChanged(name: String) {
    this.name.value = name
  }

  override fun onSignInClick() {
    val userId = database.addUser(this.login.value, this.password.value, this.name.value)
    onSignIn(userId)
  }

  override fun onAuthorizationClick() {
    onAuthorization()
  }
}
