package org.example.job_posting_service.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import theme.BaseFont
import theme.ButtonBackground
import theme.buttonSize
import theme.second_layer_shape

@Composable
fun BasicIconButton(
  imageVector: ImageVector,
  onClickAction: () -> Unit,
  contentDescription: String? = null,
  backgroundColor: Color = ButtonBackground,
) {
  Button(
    onClick = onClickAction,
    modifier = Modifier.size(buttonSize),
    shape = second_layer_shape,
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
  ) {
    Icon(
      imageVector,
      contentDescription = contentDescription,
      tint = BaseFont,
    )
  }
}
