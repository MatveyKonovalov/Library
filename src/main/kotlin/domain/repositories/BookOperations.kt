package org.example.domain.repositories

import org.example.domain.models.Book

interface BookOperations {
    fun addBook(title: String, author: String, isbn: String, genre: String)
    fun addBook(title: String, author: String, isbn: String, genre: String, amount: Int)
    fun removeBook(isbn: String): Book?
    fun findBook(isbn: String): Book?
    fun reduceBookAmount(isbn: String, amount: Int): Int?
}