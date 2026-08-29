package org.example.data.daos

import org.example.domain.models.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookDao @Inject constructor() {
    // key: isbn; value: self book and amount
    private val books = mutableMapOf<String, Book>()

    fun addBook(title: String, author: String, isbn: String, genre: String, amount: Int) {
        if (books.contains(isbn)) {
            books[isbn]?.plusBook(amount)
        } else {
            books[isbn] = Book(title, author, isbn, genre, amount)
        }
    }

    fun removeBook(isbn: String): Book? {
        return books.remove(isbn)
    }

    fun findBook(isbn: String): Book? {
        return books[isbn]
    }

    fun reduceBookAmount(isbn: String, amount: Int): Int? {
        return books[isbn]?.reduceBook()
    }
}