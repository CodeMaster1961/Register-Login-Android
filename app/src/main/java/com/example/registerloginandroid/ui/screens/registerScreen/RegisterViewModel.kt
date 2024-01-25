package com.example.registerloginandroid.ui.screens.registerScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow(User("", "", "", ""))
    val user: StateFlow<User> get() = _user

    fun onValueChange(user: User) {
        _user.value = user
    }

    fun createUser() {
        viewModelScope.launch {
            repository.registerUser(_user.value)
        }
    }
}