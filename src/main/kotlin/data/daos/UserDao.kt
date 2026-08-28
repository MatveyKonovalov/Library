package org.example.data.daos

import org.example.domain.models.User
import org.example.domain.repositories.UserOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDao @Inject constructor(): UserOperations{
    private val users = mutableMapOf<String, User>()

    override fun findUser(userId: String): User? {
        return users[userId]
    }

    override fun registerUser(user: User) {
        if (users[user.userId] != null){

        }
    }
}