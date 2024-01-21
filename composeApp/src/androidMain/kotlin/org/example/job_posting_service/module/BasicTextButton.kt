package org.example.job_posting_service.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.job_posting_service.ui.theme.ProfileTypography
import org.example.job_posting_service.ui.theme.buttonSize
import theme.ButtonBackground
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
    Text(text = text, style = ProfileTypography.labelMedium)
  }
}
