package org.example.data.daos

import org.example.domain.models.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookDao @Inject constructor() {
    companion object {
        private const val FILENAME = "books.txt"
    }
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

    fun findBookByIsbn(isbn: String): Book? {
        return books[isbn]
    }

    fun reduceBookAmount(isbn: String, amount: Int): Int? {
        return books[isbn]?.reduceBook(amount)
    }

    fun getAllBooks(): List<Book> {
        return books.values.toList()
    }

    fun findBookByAuthor(author: String): List<Book> {
        return books.values.filter { book -> book.author == author }
    }

    fun findBookByTitle(title: String): Book? {
        books.values.forEach { book: Book ->
            if (book.title == title) {
                return book
            }
        }
        return null
    }


}