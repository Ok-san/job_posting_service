package org.example.job_posting_service.module

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration
import org.example.job_posting_service.ui.theme.InterTypography

@Composable
fun BasicTextLink(
  text: String,
  onClickAction: () -> Unit,
) {
  TextButton(
    onClick = onClickAction,
  ) {
    Text(
      text = text,
      textDecoration = TextDecoration.Underline,
      style = InterTypography.labelMedium,
    )
  }
}
