package org.example.domain.repositories

import org.example.domain.models.User
import org.example.domain.models.UserType

interface UserOperations {
    fun registerUser(name: String, email: String, userType: UserType): String
    fun findUser(userId: String): User?
    fun getAllUsers(): List<User>

    fun saveInFile()
}