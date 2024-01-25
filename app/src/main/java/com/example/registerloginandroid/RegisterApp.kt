package com.example.registerloginandroid

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.registerloginandroid.ui.screens.navigation.RegistrationNavHost

@Composable
fun RegisterApp(navHostController: NavHostController = rememberNavController()) {
    RegistrationNavHost(navHostController = navHostController)
}