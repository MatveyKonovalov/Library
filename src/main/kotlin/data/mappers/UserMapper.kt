package org.example.data.mappers

import org.example.data.entities.UserEntity
import org.example.domain.models.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserMapper @Inject constructor() {
    fun toUser(userEntity: UserEntity): User {
        val user = when (userEntity.type) {
            UserType.GUEST -> Guest(name = userEntity.name, userId = userEntity.userId, email = userEntity.email)
            UserType.FACULTY -> Faculty(name = userEntity.name, userId = userEntity.userId, email = userEntity.email)
            UserType.STUDENT -> Student(name = userEntity.name, userId = userEntity.userId, email = userEntity.email)
        }
        for (isbn in userEntity.booksList) {
            user.takeBook(isbn)
        }
        return user
    }

    fun toUserEntity(user: User): UserEntity {
        val type = when (user) {
            is Faculty -> UserType.FACULTY
            is Student -> UserType.STUDENT
            is Guest -> UserType.GUEST

            else -> UserType.GUEST
        }

        return UserEntity(
            name = user.name,
            userId = user.userId,
            email = user.email,
            booksList = user.borrowedBooks,
            type = type
        )
    }
}