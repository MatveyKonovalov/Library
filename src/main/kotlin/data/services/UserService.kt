package org.example.data.services

import org.example.data.daos.UserDao
import org.example.domain.models.*
import org.example.domain.repositories.UserOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(private val userDao: UserDao) : UserOperations {
    override fun registerUser(name: String, email: String, userType: UserType): String {
        return userDao.registerUser(name, email, userType)
    }

    override fun findUser(userId: String): User? {
        return userDao.findUser(userId)
    }

    override fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    override fun saveInFile() {
        userDao.saveUserInFile()
    }

}