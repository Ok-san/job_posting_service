package component.identification.authorization

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import network.DefaultDatabase

class AuthorizationComponent(
  componentContext: ComponentContext,
  val onSignIn: (userId: Int?) -> Unit,
  val onRegistration: () -> Unit,
  private val database: DefaultDatabase,
  // private val authorizationRepository: IdentificationRepository
) : ComponentContext by componentContext, Authorization {
  override val login = MutableStateFlow("user1")
  override val password = MutableStateFlow("user1")
  override val inProgress = MutableStateFlow(false)
//    private val coroutineScope = componentCoroutineScope()

  override fun onLoginChanged(login: String) {
    this.login.value = login
  }

  override fun onPasswordChanged(password: String) {
    this.password.value = password
  }

  override fun onSignInClick() {
    val userId: Int? = database.searchUser(login.value, password.value)
    onSignIn(userId)
  }

  override fun onRegistrationClick() {
    onRegistration()
  }
}

// fun ComponentContext.componentCoroutineScope(): CoroutineScope {
//    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
//
//    if (lifecycle.state != Lifecycle.State.DESTROYED) {
//        lifecycle.doOnDestroy {
//            scope.cancel()
//        }
//    } else {
//        scope.cancel()
//    }
//
//    return scope
// }
