package com.example.registerloginandroid.ui.screens.registerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.ui.screens.navigation.NavigationDestination

object RegisterDestination : NavigationDestination {
    override val route: String = "register"
    override val titleRes: Int = 1
}

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, modifier: Modifier = Modifier) {
    val user by viewModel.user.collectAsState()
    Column {
        RegisterForm(
            user = user,
            onUserValueChange = viewModel::onValueChange,
            onSaveClick = {
                viewModel.createUser()
            })
    }
}

@Composable
fun RegisterForm(
    user: User,
    onUserValueChange: (User) -> Unit,
    onSaveClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = user.firstName, onValueChange = {
            onUserValueChange(user.copy(firstName = it))
        })
        OutlinedTextField(value = user.lastName, onValueChange = {
            onUserValueChange(user.copy(lastName = it))
        })
        OutlinedTextField(value = user.email, onValueChange = {
            onUserValueChange(user.copy(email = it))
        })
        OutlinedTextField(value = user.password, onValueChange = {
            onUserValueChange(user.copy(password = it))
        })
        Button(onClick = onSaveClick) {
            Text(text = "Register")
        }
    }
}


@Composable
fun HelloWorldText(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World!")
    }
}