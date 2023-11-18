package org.example.job_posting_service.navigation

import org.example.job_posting_service.R

sealed class NavigationItem(var route: String, var icon: Int) {
    object Home :           NavigationItem("home",          R.drawable.ic_home)
//    object Notification :   NavigationItem("notification",  R.drawable.ic_notification)
    object Favorites :      NavigationItem("favorites",     R.drawable.ic_favorite_false)
    object Profile :        NavigationItem("profile",       R.drawable.ic_profile)
}