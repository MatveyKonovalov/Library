package org.example.domain.models

class Faculty(name: String, userId: String, email: String) : User(name, userId, email) {
    companion object CommonInfo {
        private const val MAX_BOOKS: Int = 10
        private const val BORROW_DAYS: Int = 30
        private const val FINE_PER_DAY: Double = 0.50
    }

    override fun getMaxBooks(): Int = MAX_BOOKS
    override fun getBorrowDays(): Int = BORROW_DAYS
    override fun getFinePerDay(): Double = FINE_PER_DAY
}