package org.example.job_posting_service.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.job_posting_service.ui.theme.buttonSize
import theme.BackButtonTint
import theme.ButtonBackground
import theme.second_layer_shape

@Composable
fun BackButton(onClickAction: () -> Unit) {
  Button(
    onClick = onClickAction,
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
