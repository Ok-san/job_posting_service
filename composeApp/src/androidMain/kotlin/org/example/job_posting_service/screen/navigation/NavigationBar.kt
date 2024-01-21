package org.example.job_posting_service.screen.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import page.main.MainPage
import page.main.navigationBar
import theme.BackButtonTint
import theme.BaseFont
import theme.richYellow

@Composable
fun BottomNavigationBar(onClick: (MainPage.Tab) -> Unit) {
  BottomNavigation(
    modifier = Modifier.height(52.dp),
    backgroundColor = Color.White,
    contentColor = richYellow,
  ) {
    navigationBar.forEach { tab ->
      BottomNavigationItem(
        icon = {
          Icon(
            tab.icon,
            modifier = Modifier.size(30.dp),
            contentDescription = null,
            tint = BackButtonTint,
          )
        },
        selected = true,
        selectedContentColor = BaseFont,
        onClick = {
          onClick(tab.tab)
        },
      )
    }
  }
}
