package com.example.registerloginandroid.ui.screens.loginScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.registerloginandroid.data.models.Login
import com.example.registerloginandroid.ui.screens.navigation.NavigationDestination

object LoginDestination : NavigationDestination {
    override val route: String = "login"
    override val titleRes: Int = 1
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    val userLogin by viewModel.loginUser.collectAsState()
    LoginForm(
        userLogin = userLogin,
        onUserValueChange = viewModel::onLoginUserChange,
        onLoginClick = {
            viewModel.loginUser()
        }
    )
}

@Composable
fun LoginForm(
    userLogin: Login,
    onUserValueChange: (Login) -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = userLogin.email, onValueChange = {
            onUserValueChange(userLogin.copy(email = it))
        })
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedTextField(value = userLogin.password, onValueChange = {
            onUserValueChange(userLogin.copy(password = it))
        })
        Button(onClick = { onLoginClick() }) {
            Text(text = "Login")
        }
    }
}