package org.example.data.services

import org.example.data.daos.BookDao
import org.example.domain.models.Book
import org.example.domain.repository.BookOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookService @Inject constructor(private val bookDao: BookDao) : BookOperations {
    override fun addBook(book: Book) {
        bookDao.addBook(book)
    }

    override fun removeBook(isbn: String): Boolean {
        return bookDao.removeBook(isbn)
    }

    override fun findBook(isbn: String): Book? {
        return bookDao.findBook(isbn)
    }
}