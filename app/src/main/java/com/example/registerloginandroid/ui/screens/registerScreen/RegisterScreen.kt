package com.example.registerloginandroid.ui.screens.registerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.ui.screens.navigation.NavigationDestination

object RegisterDestination : NavigationDestination {
    override val route: String = "register"
    override val titleRes: Int = 1
}

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, modifier: Modifier = Modifier) {
    val user by viewModel.user.collectAsState()
    RegisterForm(
        user = user,
        onUserValueChange = viewModel::onValueChange,
        onSaveClick = {
            viewModel.createUser()
        })
}

/**
 * form for registration
 * @author Ömer Aynaci
 * @param user the user data model
 * @param onUserValueChange when user types something in the input it changes
 * @param onSaveClick if inputs are valid it registers the user
 */
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
        }, label = { Text(text = "First Name") })
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedTextField(value = user.lastName, onValueChange = {
            onUserValueChange(user.copy(lastName = it))
        }, label = { Text(text = "Last Name") })
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedTextField(value = user.email, onValueChange = {
            onUserValueChange(user.copy(email = it))
        }, label = { Text(text = "Email") })
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedTextField(
            value = user.password,
            onValueChange = {
                onUserValueChange(user.copy(password = it))
            },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text(text = "Password") })
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        Button(onClick = onSaveClick) {
            Text(text = "Register")
        }
    }
}