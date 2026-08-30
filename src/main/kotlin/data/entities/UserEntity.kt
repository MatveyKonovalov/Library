package org.example.data.entities

import kotlinx.serialization.Serializable
import org.example.domain.models.UserType

@Serializable
data class UserEntity(
    val name: String,
    val userId: String,
    val email: String,
    val booksList: List<String>,
    val type: UserType
)