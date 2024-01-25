package com.example.registerloginandroid.ui.screens

import androidx.lifecycle.ViewModel
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.data.repository.UserRepository

class RegisterViewModel (
    private val repository: UserRepository
) : ViewModel() {

    suspend fun createUser(user: User) {
        repository.registerUser(user)
    }
}