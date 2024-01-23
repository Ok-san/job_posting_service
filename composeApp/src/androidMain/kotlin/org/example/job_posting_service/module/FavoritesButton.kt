package org.example.job_posting_service.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import theme.ButtonBackground
import theme.FavoriteButtonTint
import theme.buttonSize
import theme.second_layer_shape

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
