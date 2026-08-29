package org.example.domain.models

enum class UserType(val maxBooks: Int, val borrowDays: Int, val finePerDay: Double) {
    GUEST(1, 7, 1.50),
    STUDENT(3, 14, 0.50),
    FACULTY(10, 30, 0.30)
}