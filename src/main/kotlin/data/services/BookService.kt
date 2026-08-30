package org.example.data.services

import org.example.data.daos.BookDao
import org.example.domain.models.Book
import org.example.domain.repositories.BookOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookService @Inject constructor(private val bookDao: BookDao) : BookOperations {
    override fun addBook(title: String, author: String, isbn: String, genre: String): Pair<Boolean, Book> {
        return addBook(title, author, isbn, genre, 1)
    }

    override fun addBook(title: String, author: String, isbn: String, genre: String, amount: Int): Pair<Boolean, Book> {
        return bookDao.addBook(title, author, isbn, genre, amount)
    }

    override fun removeBook(isbn: String): Book? {
        return bookDao.removeBook(isbn)
    }

    override fun findBookByIsbn(isbn: String): Book? {
        return bookDao.findBookByIsbn(isbn)
    }

    override fun reduceBookAmount(isbn: String, amount: Int): Pair<Boolean, Int> {
        return bookDao.reduceBookAmount(isbn, amount)
    }

    override fun getAllBooks(): List<Book> {
        return bookDao.getAllBooks()
    }

    override fun findBookByAuthor(author: String): List<Book> {
        return bookDao.findBookByAuthor(author)
    }

    override fun findBookByTitle(title: String): List<Book> {
        return bookDao.findBookByTitle(title)
    }

    override fun saveInFile() {
        bookDao.saveBooksInFile()
    }
}