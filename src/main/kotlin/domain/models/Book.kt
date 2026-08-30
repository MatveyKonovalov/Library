package org.example.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val author: String,
    val isbn: String,
    val genre: String,
    private var freeAmount: Int = 0
) {
    fun isAvailable() = freeAmount > 0

    fun takeBook(): Boolean {
        if (isAvailable()) {
            reduceBook()
            return true
        }
        return false
    }

    fun plusBook(amount: Int = 1) {
        freeAmount += amount
    }

    fun reduceBook(amount: Int = 1): Boolean {
        if (amount >= 0 && freeAmount - amount >= 0) {
            freeAmount -= amount
            return true
        }
        return false
    }

    fun getFreeAmount() = freeAmount
}