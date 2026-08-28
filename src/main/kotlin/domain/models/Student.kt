package org.example.domain.models

class Student: User() {
    companion object CommonInfo{
        private const val MAX_BOOKS: Int = 3
        private const val BORROW_DAYS: Int = 14
        private const val FINE_PER_DAY: Double = 50.0 //
    }
    override fun getMaxBooks(): Int {
        TODO("Not yet implemented")
    }

    override fun getBorrowDays(): Int {
        TODO("Not yet implemented")
    }

    override fun getFinePerDay(): Double {
        TODO("Not yet implemented")
    }

}