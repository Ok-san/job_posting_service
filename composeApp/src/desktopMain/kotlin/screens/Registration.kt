package screens

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
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import theme.applicationTitle
import ui.theme.ProfileTypography
import ui.theme.mainIconSize
import ui.theme.maxAuthScreenWidth
import ui.theme.minAuthScreenWidth

@Composable
fun RegistrationScreen(component: Registration) {

    val name by component.login.collectAsState(Dispatchers.Main.immediate)
    val login by component.login.collectAsState(Dispatchers.Main.immediate)
    val password by component.password.collectAsState(Dispatchers.Main.immediate)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.widthIn(minAuthScreenWidth, maxAuthScreenWidth),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Image(
                painterResource("drawable/logo.xml"),
                contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .size(mainIconSize)
            )
            Text(
                applicationTitle,
                style = ProfileTypography.titleMedium
            )
            Column(modifier = Modifier.padding(top = 34.dp)) {
                DefaultField(text = "Name:", message = name, change = component::onNameChanged)
                Box(
                    modifier = Modifier.padding(top = 17.dp)
                ) {
                    DefaultField(
                        text = "Email:",
                        message = login,
                        change = component::onLoginChanged
                    )
                }
                Box(
                    modifier = Modifier.padding(top = 17.dp)
                ) {
                    DefaultField(
                        text = "Password:",
                        message = password,
                        change = component::onPasswordChanged
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 34.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AuthorizationButton(component)
                    ForwardButton(component)
                }
            }
        }
    }
}

@Composable
fun AuthorizationButton(component: Registration) {
    TextButton(
        onClick = component::onAuthorizationClick
    ) {
        Text(
            text = "Authorization",
            textDecoration = TextDecoration.Underline,
            style = ProfileTypography.labelMedium
        )
    }
}