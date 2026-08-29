package org.example.data.daos

import org.example.domain.models.User
import org.example.domain.repositories.UserOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDao @Inject constructor(){
    private val users = mutableMapOf<String, User>()

    fun findUser(userId: String): User? {
        return users[userId]
    }

    fun registerUser(user: User) {
        if (users[user.userId] != null){
            throw IllegalArgumentException("User with this userId<${user.userId}> already exists")
        }
        users[user.userId] = user
    }
}