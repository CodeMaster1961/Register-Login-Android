package com.example.registerloginandroid.data.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)