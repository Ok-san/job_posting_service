package org.example.job_posting_service.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.example.job_posting_service.ui.theme.Typography
import org.example.job_posting_service.ui.theme.buttonSize
import theme.BaseFont
import theme.ButtonBackground
import theme.second_layer_shape

@Composable
fun CompoundButton(
  text: String,
  imageVector: ImageVector,
  onClickAction: () -> Unit,
  backgroundColor: Color = ButtonBackground,
) {
  Button(
    onClick = onClickAction,
    modifier = Modifier.height(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(
        imageVector,
        contentDescription = "",
        tint = BaseFont,
      )
      Text(
        text = text,
        modifier = Modifier.padding(start = 6.dp),
        color = BaseFont,
        style = Typography.labelMedium,
      )
    }
  }
}
