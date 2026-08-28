package org.example.data.daos

import org.example.domain.models.Book
import org.example.domain.repository.BookOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookDao @Inject constructor(): BookOperations {
    // key: isbn; value: self book and amount
    private val books = mutableMapOf<String, Pair<Book, Int>>()

    override fun addBook(book: Book) {
        val key: String = book.isbn
        val amount: Int = books[key]?.second ?: 0
        books[key] = book to amount
    }

    override fun removeBook(isbn: String): Boolean {
        return books.remove(isbn) != null
    }

    override fun findBook(isbn: String): Book?{
        return books[isbn]?.first
    }
}