package org.example.job_posting_service.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import org.example.job_posting_service.R
import page.main.home.HomePage
import theme.BaseFont

@Composable
fun HomeScreen(component: HomePage) {
  Children(
    stack = component.childStack,
    animation = stackAnimation(slide()),
  ) {
    when (val child = it.instance) {
      is HomePage.Child.OrderListChild -> OrdersListScreen(component = child.component)
      is HomePage.Child.OrderDetailsChild -> OrderDetailsScreen(component = child.component)
    }
  }
}

@Composable
fun SettingBar() {
  var text by remember { mutableStateOf(TextFieldValue("")) }

  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
    modifier =
      Modifier
        .padding(top = 47.dp, start = 20.dp, end = 20.dp)
        .height(50.dp)
        .fillMaxWidth(),
  ) {
    TextField(
      value = text,
      shape = RoundedCornerShape(size = 10.dp),
      onValueChange = { newText ->
        text = newText
      },
      textStyle =
        TextStyle(
          fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
          fontWeight = FontWeight(400),
          color = BaseFont,
        ),
      placeholder = {
        Text(
          text = "Search",
          fontSize = 16.sp,
//                fontFamily = FontFamily(Font(R.font.inter)),
          fontWeight = FontWeight(400),
          color = BaseFont,
        )
      },
      colors =
        TextFieldDefaults.textFieldColors(
          backgroundColor = Color(0x308A9994),
          focusedIndicatorColor = Color.Transparent,
          unfocusedIndicatorColor = Color.Transparent,
          disabledIndicatorColor = Color.Transparent,
        ),
      maxLines = 1,
    )
    IconButton(
      onClick = {},
      modifier =
        Modifier
          .width(39.dp)
          .fillMaxSize()
          .padding(6.dp)
          .background(color = Color(0x308A9994), shape = RoundedCornerShape(size = 10.dp)),
    ) {
      Image(
        alignment = Alignment.Center,
        modifier =
          Modifier
            .fillMaxHeight()
            .width(39.dp),
        painter = painterResource(id = R.drawable.icon_filter),
        contentDescription = "image description",
      )
    }
  }
}

// @Preview
// @Composable
// fun HomeScreenPreview() {
//    HomeScreen()
// }
