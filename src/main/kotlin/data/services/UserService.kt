package org.example.data.services

import org.example.data.daos.UserDao
import org.example.domain.models.User
import org.example.domain.repositories.UserOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(private val userDao: UserDao): UserOperations {
    override fun registerUser(user: User) {
        userDao.registerUser(user) // check exception (IllegalArgumentException)
    }

    override fun findUser(userId: String): User? {
        return userDao.findUser(userId)
    }

}