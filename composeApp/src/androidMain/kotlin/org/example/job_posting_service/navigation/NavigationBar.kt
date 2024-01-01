package org.example.job_posting_service.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.example.job_posting_service.R
import org.example.job_posting_service.screens.FavoritesScreen
import org.example.job_posting_service.screens.HomeScreen
import org.example.job_posting_service.screens.ProfileScreen
import org.example.job_posting_service.ui.theme.BaseFont
import org.example.job_posting_service.ui.theme.richYellow
import page.main.MainPage

//@Composable
//fun Navigation(navController: NavHostController) {
//    NavHost(navController, startDestination = NavigationItem.Home.route) {
//        composable(NavigationItem.Home.route) { HomeScreen() }
////        composable(NavigationItem.Notification.route) { NotificationScreen() }
//        composable(NavigationItem.Favorites.route) { FavoritesScreen() }
//        composable(NavigationItem.Profile.route) { ProfileScreen() }
//    }
//}

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
fun BottomNavigationBar(onClick: (MainPage.Tab) -> Unit) {
    BottomNavigation(
        modifier = Modifier.height(52.dp),
        backgroundColor = Color.White,
        contentColor = richYellow,
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    modifier = Modifier.size(30.dp),
                    contentDescription = null
                )
            },
            selected = true,
            selectedContentColor = BaseFont,
            onClick = {
                onClick(MainPage.Tab.Home)
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_favorite_false),
                    modifier = Modifier.size(30.dp),
                    contentDescription = null
                )
            },
            selected = true,
            selectedContentColor = BaseFont,
            onClick = {
                onClick(MainPage.Tab.Favorites)
            }
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_profile),
                    modifier = Modifier.size(30.dp),
                    contentDescription = null
                )
            },
            selected = true,
            selectedContentColor = BaseFont,
            onClick = {
                onClick(MainPage.Tab.Profile)
            }
        )
    }
}

