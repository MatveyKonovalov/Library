package org.example.domain.models

abstract class User{
    abstract fun getMaxBooks(): Int
    abstract fun getBorrowDays(): Int
    abstract fun getFinePerDay(): Double
}