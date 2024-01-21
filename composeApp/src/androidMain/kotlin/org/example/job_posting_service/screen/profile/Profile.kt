import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import org.example.job_posting_service.screen.MainScreen
import org.example.job_posting_service.screen.auth.IdentificationScreen
import org.example.job_posting_service.screen.profile.EditableProfileScreen
import org.example.job_posting_service.screen.profile.ViewableProfileScreen
import root.Root
import root.RootComponent

//@Composable
//fun PersonalScreen(component: PersonalComponent) {
//  Children(
//    stack = component.childStack,
//    animation = stackAnimation(slide()),
//  ) {
//    when (val child = it.instance) {
//      is Personal.Child.Editable -> EditableProfileScreen(child.component)
//      is Personal.Child.Viewable -> ViewableProfileScreen(child.component)
//    }
//  }
//}
