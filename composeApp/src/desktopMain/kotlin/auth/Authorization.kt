package auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import component.identification.authorization.Authorization
import kotlinx.coroutines.Dispatchers
import module.BasicIconButton
import module.BasicInputField
import module.BasicTextLink
import theme.APPLICATION_TITLE
import theme.InterTypography
import ui.theme.mainIconSize
import ui.theme.maxAuthScreenWidth
import ui.theme.minAuthScreenWidth

@Composable
fun AuthorizationScreen(component: Authorization) {
  val login by component.login.collectAsState(Dispatchers.Main.immediate)
  val password by component.password.collectAsState(Dispatchers.Main.immediate)

  Column(
    modifier =
      Modifier.fillMaxSize()
        .padding(20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Column(
      modifier = Modifier.widthIn(minAuthScreenWidth, maxAuthScreenWidth),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Image(
        painterResource("drawable/logo.xml"),
        contentDescription = null,
        modifier =
          Modifier
            .padding(2.dp)
            .size(mainIconSize),
      )
      Text(
        APPLICATION_TITLE,
        style = InterTypography.titleMedium,
      )
      Column(modifier = Modifier.padding(top = 34.dp)) {
        BasicInputField("Email:", login, component::onLoginChanged)
        Box(modifier = Modifier.padding(top = 17.dp)) {
          BasicInputField("Password:", password, component::onPasswordChanged)
        }
        Row(
          modifier =
            Modifier
              .fillMaxWidth()
              .padding(top = 34.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          BasicTextLink("Registration", component::onRegistrationClick)
          BasicIconButton(imageVector = Icons.Default.ArrowForward, onClickAction = component::onSignInClick)
        }
      }
    }
  }
}
