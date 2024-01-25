package module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.ButtonBackground
import theme.InterTypography
import theme.buttonSize
import theme.second_layer_shape

@Composable
fun BasicTextButton(
  text: String,
  onClickAction: () -> Unit,
) {
  Button(
    onClick = onClickAction,
    modifier = Modifier.height(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBackground),
  ) {
    Text(text = text, style = InterTypography.labelMedium)
  }
}
