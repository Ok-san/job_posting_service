package org.example.job_posting_service.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.profile.EditableProfile
import module.BackButton
import module.BasicInputField
import module.BasicTextButton
import theme.BaseLayer
import theme.FirstLayer
import theme.InterTypography
import theme.SecondLayer
import theme.first_layer_shape
import ui.theme.mainIconSize

@Composable
fun EditableProfileScreen(component: EditableProfile) {
  val message = remember { mutableStateOf("") }
  val model by component.model.subscribeAsState()

  Box(
    modifier = Modifier.background(BaseLayer),
  ) {
    Box(
      modifier =
        Modifier
          .fillMaxWidth()
          .zIndex(1f),
      contentAlignment = Alignment.Center,
    ) {
      Image(
        painter = painterResource("drawable/logo.xml"),
        contentDescription = null,
        modifier =
          Modifier
            .size(mainIconSize)
            .offset(y = 80.dp)
            .clip(RoundedCornerShape(mainIconSize / 2)),
      )
    }
    Column {
      Row(
        modifier =
          Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        BackButton(component::onClickBack)
        BasicTextButton("Save", component::onClickSave)
      }
      Column(
        modifier =
          Modifier
            .fillMaxSize()
            .padding(top = mainIconSize / 2 - 10.dp)
            .clip(RoundedCornerShape(40.dp, 40.dp))
            .background(FirstLayer)
            .padding(20.dp),
      ) {
        Column(
          modifier =
            Modifier
              .shadow(
                elevation = 6.dp,
                shape = first_layer_shape,
                spotColor = Color.Black,
              )
              .clip(first_layer_shape)
              .background(SecondLayer)
              .padding(10.dp),
        ) {
          Box(
            modifier =
              Modifier
                .fillMaxWidth()
                .padding(top = mainIconSize / 2 - 20.dp),
            contentAlignment = Alignment.Center,
          ) {
            Text(
              "About You",
              style = InterTypography.titleMedium,
            )
          }
          Column {
            BasicInputField("Name:", model.name, component::onChangeName)
            BasicInputField("Date of birth:", model.birthDate, component::onChangeDateBirth)
            BasicInputField("City:", model.city, component::onChangeCity)
            BasicInputField("Address", model.address, component::onChangeAddress)
            BasicInputField("Phone number:", model.phoneNumber, component::onChangePhone)
            BasicInputField("Email:", model.email, component::onChangeEmail)
          }
        }

//        Row(
//          modifier =
//            Modifier
//              .fillMaxWidth()
//              .padding(vertical = 6.dp),
//          verticalAlignment = Alignment.CenterVertically,
//          horizontalArrangement = Arrangement.SpaceBetween,
//        ) {
//          Row(verticalAlignment = Alignment.CenterVertically) {
//            val checkedState = remember { mutableStateOf(true) }
//            Checkbox(
//              checked = checkedState.value,
//              onCheckedChange = { checkedState.value = it },
//              colors =
//                CheckboxDefaults.colors(
//                  checkedColor = SecondLayer,
//                  checkmarkColor = BaseFont,
//                ),
//            )
//            Text(
//              "I'm a master",
//              style = Typography.labelMedium,
//            )
//          }
//
//          CompoundButton("Add service", Icons.Default.AddCircleOutline, {}, BaseLayer)
//        }
//
//        Column(
//          modifier =
//            Modifier
//              .shadow(
//                elevation = 6.dp,
//                shape = first_layer_shape,
//                spotColor = Color.Black,
//              )
//              .clip(first_layer_shape)
//              .background(SecondLayer)
//              .padding(10.dp),
//        ) {
//          Column {
//            DefaultField(
//              "Category:",
//              message.value,
//            ) { newText -> message.value = newText }
//            DefaultField(
//              "Specialization",
//              message.value,
//            ) { newText -> message.value = newText }
//            DefaultField(
//              "Coast:",
//              message.value,
//            ) { newText -> message.value = newText }
//          }
//          Text(
//            "Tell us more details:",
//            modifier = Modifier.padding(vertical = 6.dp),
//            style = Typography.bodyMedium,
//          )
//
//          BasicTextField(
//            value = message.value,
//            onValueChange = { newText -> message.value = newText },
//            modifier =
//              Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(20.dp))
//                .background(PlaceholderBackground)
//                .padding(12.dp, 6.dp),
//            textStyle = Typography.bodyMedium,
//            minLines = 2,
//            maxLines = 10,
//          )
//
//          Row(
//            modifier =
//              Modifier
//                .fillMaxWidth()
//                .padding(top = 10.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//          ) {
//            BasicTextButton("Save", {})
//            BasicTextButton("Edit", {})
//            CompoundButton("Delete", Icons.Default.Delete, {})
//          }
//        }
      }
    }
  }
}
