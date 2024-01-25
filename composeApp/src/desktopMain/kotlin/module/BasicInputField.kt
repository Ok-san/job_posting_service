package module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import theme.InterTypography
import theme.PlaceholderBackground

@Composable
fun BasicInputField(
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
      style = InterTypography.bodyMedium,
    )
    BasicTextField(
      value = message,
      onValueChange = change,
      modifier =
        Modifier
          .fillMaxWidth()
          .clip(RoundedCornerShape(40.dp))
          .background(PlaceholderBackground)
          .padding(12.dp, 6.dp),
      textStyle = InterTypography.bodyMedium,
      singleLine = true,
      maxLines = 1,
    )
  }
}
