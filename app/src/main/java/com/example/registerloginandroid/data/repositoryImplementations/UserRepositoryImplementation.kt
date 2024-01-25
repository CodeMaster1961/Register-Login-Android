package com.example.registerloginandroid.data.repositoryImplementations

import com.example.registerloginandroid.data.UserApi
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.data.repository.UserRepository

class UserRepositoryImplementation(
    private val api: UserApi
) : UserRepository {

    override suspend fun registerUser(user: User): User {
        return api.registerUser(user)
    }
}