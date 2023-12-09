package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface Root {
    val router: Value<ChildStack<*, Child>>

    fun onNext()
    fun onPrev()
    sealed interface Child{
        //class StartChild(val component: StartPage) : Child

    }
}