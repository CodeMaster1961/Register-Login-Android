package com.example.registerloginandroid.ui.screens.loginScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registerloginandroid.data.models.Login
import com.example.registerloginandroid.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
) : ViewModel() {
    private val _loginUser = MutableStateFlow(Login("", ""))
    val loginUser get() = _loginUser

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun onLoginUserChange(newUser: Login) {
        _loginUser.value = newUser
    }

    fun loginUser() {
        val username = _username.value ?: ""
        val password = _password.value ?: ""
        viewModelScope.launch {
            repository.loginUser(Login(username,password))
        }
    }
}