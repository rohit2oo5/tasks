package com.myapplication

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Identity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
