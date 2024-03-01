package com.myapplication

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationComposable(context: Context, navController: NavController) {

    val navController = rememberNavController()
    val startDestination = Onboarding.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route){
            Onboarding(context, navController)
        }
        composable(Home.route){
            Home(navController)
        }
    }
}