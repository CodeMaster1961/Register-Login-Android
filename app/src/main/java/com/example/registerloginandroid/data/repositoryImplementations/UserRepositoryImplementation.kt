package com.example.registerloginandroid.data.repositoryImplementations

import com.example.registerloginandroid.data.UserApi
import com.example.registerloginandroid.data.models.User
import com.example.registerloginandroid.data.repository.UserRepository
class UserRepositoryImplementation(
    private val api: UserApi
) : UserRepository {

    /**
     * creates a user
     * @author Ömer Aynaci
     * @param user the user data model
     * @return user data model
     */
    override suspend fun registerUser(user: User): User {
        return api.registerUser(user)
    }
}