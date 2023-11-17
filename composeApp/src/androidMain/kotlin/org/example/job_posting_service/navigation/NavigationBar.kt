package org.example.job_posting_service.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.job_posting_service.screens.FavoritesScreen
import org.example.job_posting_service.screens.HomeScreen
import org.example.job_posting_service.screens.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeScreen() }
//        composable(NavigationItem.Notification.route) { NotificationScreen() }
        composable(NavigationItem.Favorites.route) { FavoritesScreen() }
        composable(NavigationItem.Profile.route) { ProfileScreen() }
    }
}

//@Composable
//fun TopBar() {
//    TopAppBar(
//        title = {
//            androidx.compose.material.Text(
//                //text = stringResource(androidx.compose.material.R.string.app_name),
//                text = "gwg",
//                fontSize = 18.sp
//            )
//        },
//        //backgroundColor = colorResource(id = androidx.compose.material.R.color.colorPrimary),
//        backgroundColor = Color.Magenta,
//        contentColor = Color.White
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun TopBarPreview() {
//    TopBar()
//}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
//        NavigationItem.Notification,
        NavigationItem.Favorites,
        NavigationItem.Profile,
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null, //contentDescription = item.title,
                        modifier = Modifier.size(40.dp)
                    )
                },
                //label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // selecting the same item
                        launchSingleTop = true
                        // Restore state when selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()
    BottomNavigationBar(navController)
}