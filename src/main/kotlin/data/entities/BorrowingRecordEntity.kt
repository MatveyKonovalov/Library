package org.example.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class BorrowingRecordEntity(
    val userId: String,
    val isbn: String,
    val borrowDays: Int,
    val borrowingStartTime: List<Int>, // year; month; day
    val fine: Double
)