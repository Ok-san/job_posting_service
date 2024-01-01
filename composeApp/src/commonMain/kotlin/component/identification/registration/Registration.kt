package component.identification.registration

import kotlinx.coroutines.flow.StateFlow

interface Registration {
    val login: StateFlow<String>
    val password: StateFlow<String>
    val name: StateFlow<String>
    val inProgress: StateFlow<Boolean>

    fun onLoginChanged(login: String)
    fun onPasswordChanged(password: String)
    fun onNameChanged(password: String)
    fun onRegistrationClick()
    fun onAuthorizationClick()
}