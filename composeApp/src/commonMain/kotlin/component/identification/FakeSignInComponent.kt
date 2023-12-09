package component.identification

import kotlinx.coroutines.flow.MutableStateFlow

class FakeSignInComponent : SignIn {

    override val login = MutableStateFlow("login")
    override val password = MutableStateFlow("password")
    override val inProgress = MutableStateFlow(false)

    override fun onLoginChanged(login: String) = Unit
    override fun onPasswordChanged(password: String) = Unit
    override fun onSignInClick() = Unit
    override fun onRegistrationClick() = Unit
    override fun onRecoverClick() = Unit
}