package com.example.registerloginandroid.data

import com.example.registerloginandroid.data.models.Login
import com.example.registerloginandroid.data.models.User
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("users")
    suspend fun registerUser(@Body user: User): User

    @POST("login")
    suspend fun loginUser(@Body loginUser: Login): Login
}