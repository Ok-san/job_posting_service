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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import component.identification.authorization.Authorization
import component.identification.registration.Registration
import kotlinx.coroutines.Dispatchers
import org.jetbrains.compose.resources.ExperimentalResourceApi
import screens.AuthorizationButton

val BaseLayer = Color(0xFFFFFFFF)
val FirstLayer = Color(0xFFFCE3AD)
val SecondLayer = Color(0xFFFFFFFF)
val BaseFont = Color(0xFF3F6359)

val FavoriteButtonTint = Color(0xFFFDB3D7)
val BackButtonTint = Color(0xFF3F6359)
val ButtonBackground = Color(0xFFEDF1F6)
val PlaceholderBackground = Color(0xFFEDF1F6)

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


val mainIconSize = 100.dp
val buttonSize = 40.dp

val FirstLayerShape: Shape = RoundedCornerShape(20.dp)
val SecondLayerShape: Shape = RoundedCornerShape(10.dp)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun AuthorizationScreen() {

//    val login by component.login.collectAsState(Dispatchers.Main.immediate)
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
//            DefaultField("Email:", login, component::onLoginChanged)
            DefaultField("Email:", "", {})
            Box(
                modifier = Modifier
                    .padding(top = 17.dp)
            ) {
//                DefaultField("Password:", password, component::onPasswordChanged)
                DefaultField("Password:", "", {})
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.6f)
                    .padding(top = 34.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//                RegistrationButton(component)
//                ForwardButton(component)

                RegistrationButton()
                ForwardButton()
            }
        }
    }
}

@Composable
fun ForwardButton(component: Authorization) {
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
fun ForwardButton(/*component: Registration*/) {
    Button(
//        onClick = component::onSignInClick,
        onClick = {},
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
fun RegistrationButton(/*component: Authorization*/) {
    TextButton(
//        onClick = component::onRegistrationClick
        onClick = {}
    ) {
        Text(
            text = "Registration",
            textDecoration = TextDecoration.Underline,
            style = ProfileTypography.labelMedium
        )
    }
}

@Composable
fun DefaultField(text: String, message: String, change: (String) -> Unit) {
    Row(
        Modifier.padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text,
            modifier = Modifier
                .padding(end = 10.dp),
            style = ProfileTypography.bodyMedium
        )
        //val message = remember { mutableStateOf("") }
        BasicTextField(
            value = message,
            onValueChange = change,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(40.dp))
                .background(PlaceholderBackground)
                .padding(12.dp, 6.dp),
            textStyle = ProfileTypography.bodyMedium,
            singleLine = true,
            maxLines = 1
        )
    }
}
