package org.example.job_posting_service.screens

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import component.identification.authorization.Authorization
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import org.example.job_posting_service.R
import org.example.job_posting_service.ui.theme.BackButtonTint
import org.example.job_posting_service.ui.theme.BaseLayer
import org.example.job_posting_service.ui.theme.ButtonBackground
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.SecondLayerShape
import page.identification.IdentificationPage

@Composable
fun IdentificationScreen(component: IdentificationPage) {

    val login by component.login.collectAsState(Dispatchers.Main.immediate)
    val password by component.password.collectAsState(Dispatchers.Main.immediate)
    val inProgress by component.inProgress.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BaseLayer)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.4f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(2.dp)
                    .size(mainIconSize)
            )
            Text(
                //"Тут будет название",
                "Profi 2.0",
                style = ProfileTypography.titleMedium
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            DefaultField("Email:", login, component::onLoginChanged)
            Box(
                modifier = Modifier
                    .padding(top = 17.dp)
            ) {
                DefaultField("Password:", password, component::onPasswordChanged)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.6f)
                    .padding(top = 34.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RegistrationButton(component)
                RecoverButton(component)
                ForwardButton(component)
            }
        }
    }
}

@Composable
fun ForwardButton(component: IdentificationPage) {
    Button(
        onClick = component::onSignInClick,
        modifier = Modifier.size(buttonSize),
        shape = SecondLayerShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground)
    ) {
        Icon(
            Icons.Default.ArrowForward,
            contentDescription = "",
            tint = BackButtonTint
        )
    }
}

@Composable
fun RegistrationButton(component: Registration) {
    TextButton(
        onClick = component::onRegistrationClick
    ) {
        Text(
            text = "Registration",
            textDecoration = TextDecoration.Underline,
            style = ProfileTypography.labelMedium
        )
    }
}

@Composable
fun RecoverButton(component: Authorization) {
    TextButton(
        onClick = component::onRecoverClick,
    ) {
        Text(
            text = "Recover Password",
            textDecoration = TextDecoration.Underline,
            style = ProfileTypography.labelMedium
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun IdentificationScreenPreview() {
//
//    IdentificationScreen(component = FakeSignInComponent())
//}