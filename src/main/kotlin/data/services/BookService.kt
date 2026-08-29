package org.example.data.services

import org.example.data.daos.BookDao
import org.example.domain.models.Book
import org.example.domain.repositories.BookOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookService @Inject constructor(private val bookDao: BookDao) : BookOperations {
    override fun addBook(title: String, author: String, isbn: String, genre: String) {
        addBook(title, author, isbn, genre, 1)
    }

    override fun addBook(title: String, author: String, isbn: String, genre: String, amount: Int) {
        bookDao.addBook(title, author, isbn, genre, amount)
    }

    override fun removeBook(isbn: String): Book? {
        return bookDao.removeBook(isbn)
    }

    override fun findBook(isbn: String): Book? {
        return bookDao.findBook(isbn)
    }

    override fun reduceBookAmount(isbn: String, amount: Int): Int? {
        return bookDao.reduceBookAmount(isbn, amount)
    }

}