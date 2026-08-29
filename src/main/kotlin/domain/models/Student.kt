package org.example.domain.models

class Student(name: String, userId: String, email: String) : User(name, userId, email) {
    companion object CommonInfo {
        private val MAX_BOOKS: Int = UserType.STUDENT.maxBooks
        private val BORROW_DAYS: Int = UserType.STUDENT.borrowDays
        private val FINE_PER_DAY: Double = UserType.STUDENT.finePerDay
    }

    override fun getMaxBooks(): Int = MAX_BOOKS
    override fun getBorrowDays(): Int = BORROW_DAYS
    override fun getFinePerDay(): Double = FINE_PER_DAY
}