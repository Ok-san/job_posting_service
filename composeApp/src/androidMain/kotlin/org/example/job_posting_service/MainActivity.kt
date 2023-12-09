package org.example.job_posting_service

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.arkivanov.decompose.defaultComponentContext
import component.identification.SignInComponent
import org.example.job_posting_service.navigation.BottomNavigationBar
import org.example.job_posting_service.navigation.Navigation
import org.example.job_posting_service.screens.IdentificationScreen
import org.example.job_posting_service.ui.theme.Job_posting_serviceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent = SignInComponent(defaultComponentContext())

        setContent {
            Job_posting_serviceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MainScreen()
                    IdentificationScreen(rootComponent)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        //containerColor = Color.DarkGray // to avoid white flashing when switching screens
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Job_posting_serviceTheme {
        MainScreen()
    }
}