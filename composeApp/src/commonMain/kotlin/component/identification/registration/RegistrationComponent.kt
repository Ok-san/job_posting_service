package component.identification.registration

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow

class RegistrationComponent(
    componentContext: ComponentContext,
    val onSignIn: () -> Unit,

    ) : Registration, ComponentContext by componentContext {

    override val login: StateFlow<String> = TODO()
    override val password: StateFlow<String> = TODO()
    override val name: StateFlow<String> = TODO()
    override val inProgress: StateFlow<Boolean> = TODO()

    override fun onLoginChanged(login: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordChanged(password: String) {
        TODO("Not yet implemented")
    }

    override fun onNameChanged(password: String) {
        TODO("Not yet implemented")
    }

    override fun onRegistrationClick() {
        TODO("Not yet implemented")
        onSignIn
    }

    override fun onAuthorizationClick() {
        TODO("Not yet implemented")
    }

}