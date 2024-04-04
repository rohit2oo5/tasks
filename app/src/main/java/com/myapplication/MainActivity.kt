package com.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.myapplication.ui.theme.TasksTheme
import androidx.navigation.compose.rememberNavController
import com.myapplication.MainViewModel
import com.myapplication.NavigationComposable

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            TasksTheme {
                val navController = rememberNavController()
                NavigationComposable(context = applicationContext, navController = navController)
            }
        }
    }
}