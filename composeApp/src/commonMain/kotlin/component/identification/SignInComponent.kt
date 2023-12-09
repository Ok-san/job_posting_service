package component.identification

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInComponent(
    componentContext: ComponentContext,
    //private val authorizationRepository: IdentificationRepository
) : ComponentContext by componentContext, SignIn {

    override val login = MutableStateFlow("")
    override val password = MutableStateFlow("")
    override val inProgress = MutableStateFlow(false)
    private val coroutineScope = componentCoroutineScope()

    override fun onLoginChanged(login: String) {
        this.login.value = login
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onSignInClick() {
        coroutineScope.launch {
            inProgress.value = true
            //authorizationRepository.signIn(login.value, password.value)
            inProgress.value = false

            //переход к следующему эрану
        }
    }

    override fun onRegistrationClick() {
        TODO("Not yet implemented")
    }

    override fun onRecoverClick() {
        TODO("Not yet implemented")
    }
}

fun ComponentContext.componentCoroutineScope(): CoroutineScope {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    if (lifecycle.state != Lifecycle.State.DESTROYED) {
        lifecycle.doOnDestroy {
            scope.cancel()
        }
    } else {
        scope.cancel()
    }

    return scope
}
