package page.main.profile

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import component.profile.EditableProfile
import component.profile.ViewableProfile

interface PersonalPage {
  val childStack: Value<ChildStack<*, Child>>

  sealed class Child {
    class ViewableProfileChild(val component: ViewableProfile) : Child()

    class EditableProfileChild(val component: EditableProfile) : Child()
  }
}
