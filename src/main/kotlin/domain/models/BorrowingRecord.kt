package org.example.domain.models

import java.time.LocalDate

data class BorrowingRecord(
    val userId: String,
    val isbn: String,
    val borrowDays: Int,
    val fine: Double,
    val borrowingStartTime: LocalDate = LocalDate.now(),
)