package org.example.job_posting_service.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector) {
    object Home :           NavigationItem("home",          Icons.Default.Home)
    //object Notification :   NavigationItem("notification",  Icons.Default.Notifications)
    object Favorites :      NavigationItem("favorites",     Icons.Default.Favorite)
    object Profile :        NavigationItem("profile",       Icons.Default.Person)
}