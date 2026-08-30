package org.example.data.daos

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.data.entities.UserEntity
import org.example.data.mappers.UserMapper
import org.example.domain.models.*
import java.io.File
import java.io.FileNotFoundException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDao @Inject constructor(private val userMapper: UserMapper) {
    companion object {
        private const val FILENAME = "users.txt"
    }

    private val users by lazy {
        loadUserFromFile().toMutableMap()
    }
    private var id =
        users.keys
            .mapNotNull { it.toIntOrNull() }
            .maxOrNull()
            ?.plus(1)
            ?: 0

    fun findUser(userId: String): User? {
        return users[userId]
    }

    fun registerUser(name: String, email: String, userType: UserType): String {
        val userId = (id++).toString()

        val user = when (userType) {
            UserType.GUEST -> Guest(name, userId, email)
            UserType.FACULTY -> Faculty(name, userId, email)
            UserType.STUDENT -> Student(name, userId, email)
        }
        users[userId] = user
        return userId
    }

    fun getAllUsers(): List<User> {
        return users.values.toList()
    }

    fun saveUserInFile() {
        try {
            val jsonMap = Json.encodeToString(users.mapValues { (_, user) ->
                userMapper.toUserEntity(user)
            })
            File(FILENAME).writeText(jsonMap)
        } catch (e: Exception) {
            println("Error saving users: ${e.message}")
        }
    }

    private fun loadUserFromFile(): Map<String, User> {
        return try {
            val jsonMap = File(FILENAME).readText()
            val usersEntities: Map<String, UserEntity> = Json.decodeFromString(jsonMap)
            usersEntities.map { (key, userEntity) -> key to userMapper.toUser(userEntity) }.toMap()
        } catch (e: FileNotFoundException) {
            emptyMap()
        } catch (e: Exception){
            println("User data is corrupted. The story has been updated")
            emptyMap()
        }
    }
}