package org.example.domain.models

import java.time.LocalTime

data class BorrowingRecord(
    val recordId: String,
    val userId: String,
    val isbn: String,
    val borrowingStartTime: LocalTime = LocalTime.now()
)