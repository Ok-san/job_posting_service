package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import component.identification.authorization.Authorization
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import theme.APPLICATION_TITLE
import theme.BackButtonTint
import theme.ButtonBackground
import theme.PlaceholderBackground
import theme.second_layer_shape
import ui.theme.ProfileTypography
import ui.theme.buttonSize
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
        style = ProfileTypography.titleMedium,
      )
      Column(modifier = Modifier.padding(top = 34.dp)) {
        DefaultField("Email:", login, component::onLoginChanged)
        Box(modifier = Modifier.padding(top = 17.dp)) {
          DefaultField("Password:", password, component::onPasswordChanged)
        }
        Row(
          modifier =
            Modifier
              .fillMaxWidth()
              .padding(top = 34.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          RegistrationButton(component)
          ForwardButton(component)
        }
      }
    }
  }
}

@Composable
fun ForwardButton(component: Authorization) {
  Button(
    onClick = component::onSignInClick,
    modifier = Modifier.size(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Icon(
      Icons.Default.ArrowForward,
      contentDescription = "",
      tint = BackButtonTint,
    )
  }
}

@Composable
fun ForwardButton(component: Registration) {
  Button(
    onClick = component::onSignInClick,
    modifier = Modifier.size(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Icon(
      Icons.Default.ArrowForward,
      contentDescription = "",
      tint = BackButtonTint,
    )
  }
}

@Composable
fun RegistrationButton(component: Authorization) {
  TextButton(
    onClick = component::onRegistrationClick,
  ) {
    Text(
      text = "Registration",
      textDecoration = TextDecoration.Underline,
      style = ProfileTypography.labelMedium,
    )
  }
}

@Composable
fun DefaultField(
  text: String,
  message: String,
  change: (String) -> Unit,
) {
  Row(
    Modifier.padding(top = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text,
      modifier =
        Modifier
          .padding(end = 10.dp),
      style = ProfileTypography.bodyMedium,
    )
    // val message = remember { mutableStateOf("") }
    BasicTextField(
      value = message,
      onValueChange = change,
      modifier =
        Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(40.dp))
          .background(PlaceholderBackground)
          .padding(12.dp, 6.dp),
      textStyle = ProfileTypography.bodyMedium,
      singleLine = true,
      maxLines = 1,
    )
  }
}
