package org.example.data.daos

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.domain.models.Book
import java.io.File
import java.io.FileNotFoundException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookDao @Inject constructor() {
    companion object {
        private const val FILENAME = "books.txt"
    }

    // key: isbn; value: self book and amount
    private val books by lazy { loadBooksFromFile().toMutableMap() }

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

    fun saveBooksInFile() {
        val jsonMap = Json.encodeToString(value = books)
        File(FILENAME).writeText(jsonMap)
    }

    private fun loadBooksFromFile(): Map<String, Book> {
        return try {
            val jsonString = File(FILENAME).readText()
            Json.decodeFromString(jsonString)
        } catch (e: FileNotFoundException) {
            emptyMap()
        }
    }
}