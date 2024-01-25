package com.example.registerloginandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registerloginandroid.ui.screens.homescreen.HomeDestination
import com.example.registerloginandroid.ui.screens.homescreen.HomeScreen
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterDestination
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterScreen
import com.example.registerloginandroid.ui.screens.registerScreen.RegisterViewModel
import com.example.registerloginandroid.ui.theme.RegisterLoginAndroidTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegisterLoginAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = HomeDestination.route
                    ) {
                        composable(route = HomeDestination.route) {
                            HomeScreen(navigateToRegistration = {
                                navHostController.navigate(
                                    RegisterDestination.route
                                )
                            })
                        }
                        composable(route = RegisterDestination.route) {
                            val viewModel = getViewModel<RegisterViewModel>()
                            RegisterScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RegisterLoginAndroidTheme {

    }
}