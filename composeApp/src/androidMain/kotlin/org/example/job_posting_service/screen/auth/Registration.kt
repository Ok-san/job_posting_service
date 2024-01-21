package org.example.job_posting_service.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import org.example.job_posting_service.R
import org.example.job_posting_service.screen.profile.DefaultField
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.mainIconSize
import theme.BaseLayer

@Composable
fun RegistrationScreen(component: Registration) {
  val name by component.login.collectAsState(Dispatchers.Main.immediate)
  val login by component.login.collectAsState(Dispatchers.Main.immediate)
  val password by component.password.collectAsState(Dispatchers.Main.immediate)
//    val inProgress by component.inProgress.collectAsState()

  Column(
    modifier =
      Modifier
        .fillMaxSize()
        .background(BaseLayer)
        .padding(20.dp),
  ) {
    Column(
      modifier =
        Modifier
          .fillMaxWidth()
          .fillMaxSize(0.4f),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
    ) {
      Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier =
          Modifier
            .padding(2.dp)
            .size(mainIconSize),
      )
      Text(
        text = stringResource(R.string.app_name),
        style = ProfileTypography.titleMedium,
      )
    }
    Column(modifier = Modifier.fillMaxSize()) {
      DefaultField(text = "Name:", message = name, change = component::onNameChanged)
      Box(
        modifier = Modifier.padding(top = 17.dp),
      ) {
        DefaultField(
          text = "Email:",
          message = login,
          change = component::onLoginChanged,
        )
      }
      Box(
        modifier = Modifier.padding(top = 17.dp),
      ) {
        DefaultField(
          text = "Password:",
          message = password,
          change = component::onPasswordChanged,
        )
      }
      Row(
        modifier =
          Modifier
            .fillMaxWidth()
            .fillMaxSize(0.6f)
            .padding(top = 34.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        AuthorizationButton(component)
        ForwardButton(component)
      }
    }
  }
}

@Composable
fun AuthorizationButton(component: Registration) {
  TextButton(
    onClick = component::onAuthorizationClick,
  ) {
    Text(
      text = "Authorization",
      textDecoration = TextDecoration.Underline,
      style = ProfileTypography.labelMedium,
    )
  }
}
