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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.example.job_posting_service.R
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.buttonSize
import org.example.job_posting_service.ui.theme.mainIconSize
import theme.BackButtonTint
import theme.BaseFont
import theme.BaseLayer
import theme.ButtonBackground
import theme.FavoriteButtonTint
import theme.FirstLayer
import theme.PlaceholderBackground
import theme.SecondLayer
import theme.first_layer_shape
import theme.second_layer_shape

@Composable
fun ProfileScreen() {
  val message = remember { mutableStateOf("") }

  Box(
    modifier =
      Modifier
        .background(BaseLayer)
        .verticalScroll(rememberScrollState()),
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
        BackButton()
        LogOutButton()
        EditButton()
        FavoritesButton()
      }

      Column(
        modifier =
          Modifier
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
              style = ProfileTypography.titleMedium,
            )
          }
          Column {
            DefaultField("Name:", message.value, { newText -> message.value = newText })
            DefaultField(
              "Date of birth:",
              message.value,
              { newText -> message.value = newText },
            )
            DefaultField("City:", message.value, { newText -> message.value = newText })
            DefaultField(
              "Address",
              message.value,
              { newText -> message.value = newText },
            )
            DefaultField(
              "Phone number:",
              message.value,
              { newText -> message.value = newText },
            )
            DefaultField(
              "Email:",
              message.value,
              { newText -> message.value = newText },
            )
          }
        }

        Row(
          verticalAlignment = Alignment.CenterVertically,
        ) {
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
          Column {
            DefaultField(
              "Category:",
              message.value,
              { newText -> message.value = newText },
            )
            DefaultField(
              "Specialization",
              message.value,
              { newText -> message.value = newText },
            )
            DefaultField(
              "Coast:",
              message.value,
              { newText -> message.value = newText },
            )
          }
          Text(
            "Tell us more details:",
            modifier = Modifier.padding(vertical = 6.dp),
            style = ProfileTypography.bodyMedium,
          )

          BasicTextField(
            value = message.value,
            onValueChange = { newText -> message.value = newText },
            modifier =
              Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(PlaceholderBackground)
                .padding(12.dp, 6.dp),
            textStyle = ProfileTypography.bodyMedium,
            minLines = 2,
            maxLines = 10,
          )
        }
      }
      SaveButton()
    }
  }
}

@Composable
fun DefaultField(
  text: String,
  message: String,
  change: (String) -> Unit,
) {
  Row(
    Modifier.padding(top = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text,
      modifier =
        Modifier
          .padding(end = 10.dp),
      style = ProfileTypography.bodyMedium,
    )
    // val message = remember { mutableStateOf("") }
    BasicTextField(
      value = message,
      onValueChange = change,
      modifier =
        Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(40.dp))
          .background(PlaceholderBackground)
          .padding(12.dp, 6.dp),
      textStyle = ProfileTypography.bodyMedium,
      singleLine = true,
      maxLines = 1,
    )
  }
}

@Composable
fun BackButton() {
  Button(
    onClick = {},
    modifier = Modifier.size(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Icon(
      Icons.Default.ArrowBack,
      contentDescription = "",
      tint = BackButtonTint,
    )
  }
}

@Composable
fun LogOutButton() {
  Button(
    onClick = { },
    modifier = Modifier.height(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Text(text = "Log Out", style = ProfileTypography.labelMedium)
  }
}

@Composable
fun EditButton() {
  Button(
    onClick = { },
    modifier = Modifier.height(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Text(text = "Edit", style = ProfileTypography.labelMedium)
  }
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

@Composable
fun SaveButton() {
  Button(
    onClick = { },
    modifier =
      Modifier
        .fillMaxWidth()
        .height(52.dp),
    shape = RectangleShape,
    colors =
      ButtonDefaults.buttonColors(
        backgroundColor = BaseLayer,
        contentColor = BaseFont,
      ),
  ) {
    Text(text = "Save".uppercase(), style = ProfileTypography.titleMedium)
  }
  Divider(
    modifier = Modifier.fillMaxWidth(),
    color = BaseFont,
    thickness = 1.dp,
  )
}

@Composable
fun BottomBar() {
  BottomAppBar(
    contentPadding = PaddingValues(0.dp),
    modifier = Modifier.zIndex(2f),
  ) {
    Button(
      onClick = { },
      modifier = Modifier.fillMaxSize(),
      shape = RectangleShape,
      colors =
        ButtonDefaults.buttonColors(
          backgroundColor = BaseLayer,
          contentColor = BaseFont,
        ),
    ) {
      Text(text = "Save".uppercase(), style = ProfileTypography.titleMedium)
    }
  }
}

@Preview
@Composable
fun ProfileScreenPreview() {
  ProfileScreen()
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
  BottomBar()
}
