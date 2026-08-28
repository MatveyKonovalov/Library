package org.example.domain.repository

import org.example.domain.models.Book

interface BookOperations {
    fun addBook(book: Book)
    fun removeBook(isbn: String): Boolean
    fun findBook(isbn: String): Book?
}