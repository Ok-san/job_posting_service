package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import page.identification.IdentificationPage
import page.main.MainPage

interface Root {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class Identification(val component: IdentificationPage) : Child()
        class Main(val component: MainPage) : Child()
    }
}