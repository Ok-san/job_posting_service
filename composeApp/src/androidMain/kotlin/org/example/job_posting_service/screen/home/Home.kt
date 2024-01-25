package org.example.job_posting_service.screen.home

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import page.main.home.HomePage

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

// @Composable
// fun SettingBar() {
//  var text by remember { mutableStateOf(TextFieldValue("")) }
//
//  Row(
//    horizontalArrangement = Arrangement.SpaceBetween,
//    verticalAlignment = Alignment.CenterVertically,
//    modifier =
//      Modifier
//        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
//        .height(50.dp)
//        .fillMaxWidth(),
//  ) {
//    TextField(
//      value = text,
//      shape = RoundedCornerShape(size = 10.dp),
//      onValueChange = { newText ->
//        text = newText
//      },
//      textStyle = Typography.titleMedium,
//      placeholder = {
//        Text(
//          text = "Search",
//          style = Typography.labelMedium,
//        )
//      },
//      colors =
//        TextFieldDefaults.textFieldColors(
//          backgroundColor = BaseFont,
//          focusedIndicatorColor = Color.Transparent,
//          unfocusedIndicatorColor = Color.Transparent,
//          disabledIndicatorColor = Color.Transparent,
//        ),
//      maxLines = 1,
//    )
//    IconButton(
//      onClick = {},
//      modifier =
//        Modifier
//          .width(39.dp)
//          .fillMaxSize()
//          .padding(6.dp)
//          .background(
//            color = BaseFont,
//            shape = RoundedCornerShape(size = 10.dp)
//          ),
//    ) {
//      Image(
//        alignment = Alignment.Center,
//        modifier =
//          Modifier
//            .fillMaxHeight()
//            .width(39.dp),
//        painter = painterResource(id = R.drawable.icon_filter),
//        contentDescription = "image description",
//      )
//    }
//  }
// }
