package page.identification

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import component.identification.authorization.Authorization
import component.identification.registration.Registration

interface IdentificationPage {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class AuthorizationChild(val component: Authorization) : Child()
        class RegistrationChild(val component: Registration) : Child()
    }
}