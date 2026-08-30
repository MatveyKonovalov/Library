package org.example.domain.models

import java.time.LocalDate
import java.time.LocalTime

data class BorrowingRecord(
    val userId: String,
    val isbn: String,
    val borrowDays: Int,
    val borrowingStartTime: LocalDate = LocalDate.now(),
    val fine: Double
)