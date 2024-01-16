package component.identification.authorization

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow

class AuthorizationComponent(
    componentContext: ComponentContext,
    val onSignIn: () -> Unit,
    val onRegistration: () -> Unit,
    //private val authorizationRepository: IdentificationRepository
) : ComponentContext by componentContext, Authorization {

    override val login = MutableStateFlow("")
    override val password = MutableStateFlow("")
    override val inProgress = MutableStateFlow(false)
//    private val coroutineScope = componentCoroutineScope()

    override fun onLoginChanged(login: String) {
        this.login.value = login
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onSignInClick() {
//        coroutineScope.launch {
//            inProgress.value = true
//            //authorizationRepository.signIn(login.value, password.value)
//            inProgress.value = false
//
//            //переход к следующему эрану
//        }
        onSignIn()
    }


    override fun onRegistrationClick() {
        onRegistration()
    }
}

//fun ComponentContext.componentCoroutineScope(): CoroutineScope {
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
//}
