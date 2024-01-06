package component.identification.registration

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegistrationComponent(
    componentContext: ComponentContext,
    val onSignIn: () -> Unit,

    ) : Registration, ComponentContext by componentContext {

    override val name: StateFlow<String> = MutableStateFlow("")
    override val login: StateFlow<String> = MutableStateFlow("")
    override val password: StateFlow<String> = MutableStateFlow("")
    override val inProgress: StateFlow<Boolean> = MutableStateFlow(false)

    override fun onLoginChanged(login: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordChanged(password: String) {
        TODO("Not yet implemented")
    }

    override fun onNameChanged(password: String) {
        TODO("Not yet implemented")
    }

    override fun onSignInClick() {
        onSignIn()
    }

    override fun onAuthorizationClick() {
        TODO("Not yet implemented")
    }

}