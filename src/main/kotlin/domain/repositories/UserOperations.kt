package org.example.domain.repositories

import org.example.domain.models.User

interface UserOperations {
    fun registerUser(user: User)
    fun findUser(userId: String): User?
}