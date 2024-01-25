package com.example.registerloginandroid.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.registerloginandroid.ui.screens.homescreen.HomeDestination
import com.example.registerloginandroid.ui.screens.homescreen.HomeScreen
import com.example.registerloginandroid.ui.screens.registerScreen.HelloWorldText
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterDestination
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterScreen
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterViewModel

@Composable
fun RegistrationNavHost(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navHostController, startDestination = HomeDestination.route) {
        composable(route = HomeDestination.route) {
            HomeScreen(navigateToRegistration = { navHostController.navigate(RegisterDestination.route) })
        }
        composable(route = RegisterDestination.route) {
            val viewModel = viewModel<RegisterViewModel>()
           RegisterScreen(viewModel)
        }
    }
}