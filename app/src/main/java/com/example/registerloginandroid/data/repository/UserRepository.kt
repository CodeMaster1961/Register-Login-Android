package com.example.registerloginandroid.data.repository

import com.example.registerloginandroid.data.models.Login
import com.example.registerloginandroid.data.models.User

interface UserRepository {
    suspend fun registerUser(user: User): User

    suspend fun loginUser(loginUser: Login): Login
}