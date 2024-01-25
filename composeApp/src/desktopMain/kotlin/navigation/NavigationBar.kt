package navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import page.main.MainPage
import page.main.navigationBar
import theme.BackButtonTint
import theme.InterTypography
import ui.theme.navigationBarSize

@Composable
fun NavigationBar(onClick: (MainPage.Tab) -> Unit) {
  Column(
    modifier =
      Modifier
        .fillMaxHeight()
        .width(navigationBarSize)
        .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Image(
      painterResource("drawable/logo.xml"),
      contentDescription = null,
      modifier =
        Modifier
          .padding(2.dp, 2.dp, 2.dp, 10.dp)
          .size(65.dp),
    )
    navigationBar.forEach { tab ->
      Box(
        modifier =
          Modifier
            .padding(vertical = 10.dp)
            .align(Alignment.CenterHorizontally),
      ) {
        TextButton(
          contentPadding = PaddingValues(2.dp),
          onClick = { onClick(tab.tab) },
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            Icon(
              tab.icon,
              contentDescription = tab.title,
              tint = BackButtonTint,
            )
            Text(
              text = tab.title,
              style = InterTypography.labelSmall,
            )
          }
        }
      }
    }
  }
}
