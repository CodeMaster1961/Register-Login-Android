package com.example.registerloginandroid.ui.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.registerloginandroid.R
import com.example.registerloginandroid.ui.screens.navigation.NavigationDestination

object HomeDestination : NavigationDestination {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun HomeScreen(
    navigateToRegistration: () -> Unit,
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateToRegistration() }) {
            Text(text = "Create account")
        }
        Spacer(modifier = Modifier.padding(top = 15.dp))
        Button(onClick = { navigateToLogin() }) {
            Text(text = "Login")
        }
    }
}