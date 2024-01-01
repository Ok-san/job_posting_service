package component.identification.authorization

import kotlinx.coroutines.flow.StateFlow

interface Authorization {
    val login: StateFlow<String>
    val password: StateFlow<String>
    val inProgress: StateFlow<Boolean>

    fun onLoginChanged(login: String)
    fun onPasswordChanged(password: String)
    fun onSignInClick()
    fun onRegistrationClick()
    fun onRecoverClick()
}