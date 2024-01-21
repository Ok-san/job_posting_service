package org.example.job_posting_service.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import data.OrdersModel
import data.ProfileModel
import data.ServicesModel
import data.order1
import data.order2
import data.profile1
import data.service1
import data.service2
import org.example.job_posting_service.R
import org.example.job_posting_service.module.BackButton
import org.example.job_posting_service.module.BasicTextButton
import org.example.job_posting_service.module.CompoundButton
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.buttonSize
import org.example.job_posting_service.ui.theme.mainIconSize
import org.jetbrains.compose.resources.ExperimentalResourceApi
import theme.BaseFont
import theme.BaseLayer
import theme.ButtonBackground
import theme.FavoriteButtonTint
import theme.FirstLayer
import theme.PlaceholderBackground
import theme.SecondLayer
import theme.first_layer_shape
import theme.second_layer_shape

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ViewableProfileScreen() {
  // / вот тут чтото нормальное должно быть
  val user: ProfileModel = profile1
  val services: ArrayList<ServicesModel> = arrayListOf(service1, service2)
  val orders: ArrayList<OrdersModel> = arrayListOf(order1, order2)
  // /

  val message = remember { mutableStateOf("") }

  Box(
    modifier =
      Modifier
        .background(BaseLayer),
  ) {
    Box(
      modifier =
        Modifier
          .fillMaxWidth()
          .zIndex(1f),
      contentAlignment = Alignment.Center,
    ) {
      Image(
        painter = painterResource(id = R.drawable.logo),
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
        BackButton({})
        BasicTextButton("Log Out", {})
        BasicTextButton("Edit", {})
        FavoritesButton()
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
              text = user.name,
              style = ProfileTypography.titleMedium,
            )
          }
          Column {
            PersonalInfoField("Email: " + user.email)
            PersonalInfoField("Date of birth: " + user.birthdate)
            PersonalInfoField("City: " + user.city)
            PersonalInfoField("Phone number: " + user.phoneNumber)
          }
        }

        Row(
          modifier =
            Modifier
              .fillMaxWidth()
              .padding(vertical = 6.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            val checkedState = remember { mutableStateOf(true) }
            Checkbox(
              checked = checkedState.value,
              onCheckedChange = { checkedState.value = it },
              colors =
                CheckboxDefaults.colors(
                  checkedColor = SecondLayer,
                  checkmarkColor = BaseFont,
                ),
            )
            Text(
              "I'm a master",
              style = ProfileTypography.labelMedium,
            )
          }

          CompoundButton("Add service", Icons.Default.AddCircleOutline, {}, BaseLayer)
        }

//        orders payment

        services?.forEach { service ->
          Column(
            modifier =
              Modifier
                .padding(bottom = 10.dp)
                .shadow(
                  elevation = 6.dp,
                  shape = first_layer_shape,
                  spotColor = Color.Black,
                )
                .clip(first_layer_shape)
                .background(SecondLayer)
                .padding(10.dp),
          ) {
            Column {
              Column {
                Row {
                  PersonalInfoField(service.category)
                  PersonalInfoField(service.specialization)
                  service.city?.let {
                    PersonalInfoField(service.city!!)
                  }
                  PersonalInfoField(service.publicationDate)
                  service.coast?.let {
                    PersonalInfoField(service.coast!!)
                  }
                }
//                PersonalInfoField("Category: " + service.category)
//                PersonalInfoField("Specialty: " + service.specialization)
//                PersonalInfoField("City: " + service.city)
//                PersonalInfoField("Publication date: " + service.publicationDate)
//                PersonalInfoField("Price: " + service.coast)
//                PersonalInfoField("Details: " + service.description)
              }
              PersonalInfoField(service.description)
            }

            Row(
              modifier =
                Modifier
                  .fillMaxWidth()
                  .padding(top = 10.dp),
              horizontalArrangement = Arrangement.SpaceBetween,
            ) {
              BasicTextButton("Save", {})
              BasicTextButton("Edit", {})
              CompoundButton("Delete", Icons.Default.Delete, {})
            }
          }
        }
      }
    }
  }
}

// @Composable
// fun DefaultField(
//  text: String,
//  message: String,
//  change: (String) -> Unit,
// ) {
//  Row(
//    Modifier.padding(top = 8.dp),
//    verticalAlignment = Alignment.CenterVertically,
//  ) {
//    Text(
//      text,
//      modifier =
//      Modifier
//        .padding(end = 10.dp),
//      style = ProfileTypography.bodyMedium,
//    )
//    // val message = remember { mutableStateOf("") }
//    BasicTextField(
//      value = message,
//      onValueChange = change,
//      modifier =
//      Modifier
//        .fillMaxWidth()
//        .clip(RoundedCornerShape(40.dp))
//        .background(PlaceholderBackground)
//        .padding(12.dp, 6.dp),
//      textStyle = ProfileTypography.bodyMedium,
//      singleLine = true,
//      maxLines = 1,
//    )
//  }
// }

@Composable
fun PersonalInfoField(text: String) {
  Text(
    text = text,
    modifier =
      Modifier
        .clip(RoundedCornerShape(20.dp))
        .background(PlaceholderBackground)
        .padding(12.dp, 4.dp),
    style = ProfileTypography.bodyMedium,
  )
}

@Composable
fun FavoritesButton() {
  Button(
    onClick = { },
    modifier = Modifier.size(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Icon(
      Icons.Default.Favorite,
      contentDescription = "",
      modifier = Modifier.padding(0.dp),
      tint = FavoriteButtonTint,
    )
  }
}

@Preview
@Composable
fun ViewableProfileScreenPreview() {
  ViewableProfileScreen()
}

// @Composable
// fun SaveButton() {
//  Button(
//    onClick = { },
//    modifier =
//      Modifier
//        .fillMaxWidth()
//        .height(52.dp),
//    shape = RectangleShape,
//    colors =
//      ButtonDefaults.buttonColors(
//        backgroundColor = BaseLayer,
//        contentColor = BaseFont,
//      ),
//  ) {
//    Text(text = "Save".uppercase(), style = ProfileTypography.titleMedium)
//  }
//  Divider(
//    modifier = Modifier.fillMaxWidth(),
//    color = BaseFont,
//    thickness = 1.dp,
//  )
// }

// @Composable
// fun BottomBar() {
//  BottomAppBar(
//    contentPadding = PaddingValues(0.dp),
//    modifier = Modifier.zIndex(2f),
//  ) {
//    Button(
//      onClick = { },
//      modifier = Modifier.fillMaxSize(),
//      shape = RectangleShape,
//      colors =
//        ButtonDefaults.buttonColors(
//          backgroundColor = BaseLayer,
//          contentColor = BaseFont,
//        ),
//    ) {
//      Text(text = "Save".uppercase(), style = ProfileTypography.titleMedium)
//    }
//  }
// }

// @Preview(showBackground = true)
// @Composable
// fun BottomBarPreview() {
//  BottomBar()
// }
