package screens

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
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import org.example.job_posting_service.screens.BaseFont
import org.example.job_posting_service.screens.DefaultField
import org.example.job_posting_service.screens.ForwardButton
import org.example.job_posting_service.screens.ProfileTypography
import org.example.job_posting_service.screens.RegistrationButton
import org.example.job_posting_service.screens.mainIconSize

val ProfileTypography = Typography()
private val Typography.titleMedium: TextStyle
    get() {
        return TextStyle(
            color = BaseFont,
//            fontFamily = InterFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
    }

private val Typography.labelMedium: TextStyle
    get() {
        return TextStyle(
            color = BaseFont,
//        fontFamily = InterFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        )
    }

private val Typography.bodyMedium: TextStyle
    get() {
        return TextStyle(
            color = BaseFont,
//            fontFamily = InterFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
    }

@Composable
fun RegistrationScreen() {

    //    val login by component.login.collectAsState(Dispatchers.Main.immediate)
//    val password by component.password.collectAsState(Dispatchers.Main.immediate)
//    val password by component.password.collectAsState(Dispatchers.Main.immediate)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                painterResource("logo.xml"),
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
            //            DefaultField(text = "Name:", message = name, change = component::onNameChanged)
            DefaultField(text = "Name:", message = "", change = {})
            Box(
                modifier = Modifier.padding(top = 17.dp)
            ) {
//                DefaultField(text = "Email:", message = login, change = component::onLoginChanged)
                DefaultField(text = "Email:", message = "", change = {})

            }
            Box(
                modifier = Modifier.padding(top = 17.dp)
            ) {
//                DefaultField(text = "Password:", message = password, change = component::onPasswordChanged)
                DefaultField(text = "Password:", message = "", change = {})
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.6f)
                    .padding(top = 34.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//                AuthorizationButton(component)
//                ForwardButton(component)

                AuthorizationButton()
                ForwardButton()
            }
        }
    }
}

@Composable
fun AuthorizationButton(/*component: Registration*/) {
    TextButton(
//        onClick = component::onAuthorizationClick
        onClick = {}
    ) {
        Text(
            text = "Authorization",
            textDecoration = TextDecoration.Underline,
            style = ProfileTypography.labelMedium
        )
    }
}