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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import component.identification.authorization.Authorization
import kotlinx.coroutines.Dispatchers
import org.example.job_posting_service.R
import org.example.job_posting_service.module.BasicIconButton
import org.example.job_posting_service.module.BasicInputField
import org.example.job_posting_service.module.BasicTextLink
import org.example.job_posting_service.ui.theme.InterTypography
import org.example.job_posting_service.ui.theme.mainIconSize
import theme.BaseLayer

@Composable
fun AuthorizationScreen(component: Authorization) {
  val login by component.login.collectAsState(Dispatchers.Main.immediate)
  val password by component.password.collectAsState(Dispatchers.Main.immediate)

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
        style = InterTypography.titleMedium,
      )
    }
    Column(modifier = Modifier.fillMaxSize()) {
      BasicInputField("Email:", login, component::onLoginChanged)
      Box(
        modifier = Modifier.padding(top = 17.dp),
      ) {
        BasicInputField("Password:", password, component::onPasswordChanged)
      }
      Row(
        modifier =
          Modifier
            .fillMaxWidth()
            .fillMaxSize(0.6f)
            .padding(top = 34.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        BasicTextLink("Registration", component::onRegistrationClick)
        BasicIconButton(imageVector = Icons.Default.ArrowForward, onClickAction = component::onSignInClick)
      }
    }
  }
}
