package ru.macdroid.goblin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.macdroid.goblin.common.SharedPreference
import ru.macdroid.goblin.navigation.Screen
import ru.macdroid.goblin.presentation.dashboard_page.DashboardScreen
import ru.macdroid.goblin.presentation.login_page.LoginScreen
import ru.macdroid.goblin.presentation.ui.theme.GoblinTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPreference.init(applicationContext)

        setContent {
            GoblinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val startDestination = remember { mutableStateOf(Screen.Login.route) }
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = startDestination.value // Start destination of app
                    ) {

                        composable(
                            route = Screen.Login.route
                        ) {
                            LoginScreen(navController)
                        }

                        composable(
                            route = Screen.Dashboard.route
                        ) {
                            DashboardScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
