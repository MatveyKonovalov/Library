package org.example.domain


import org.example.domain.models.*

interface LibraryOperations {
    // Book management
    fun addBooks(title: String, author: String, isbn: String, genre: String, amount: Int)
    fun removeAllBook(isbn: String): List<BorrowingRecord>
    fun findBookByIsbn(isbn: String): Book
    fun reduceAmountBook(isbn: String, amount: Int)
    fun getAllBooks(): List<Book>
    fun findBookByAuthor(author: String): List<Book>
    fun findBookByTitle(title: String): Book

    // User Management
    fun registerUser(name: String, userId: String, email: String, userType: UserType)
    fun findUser(userId: String): User
    fun getAllUsers(): List<User>

    // Borrowing operations
    fun borrowBook(userId: String, isbn: String)
    fun returnBook(userId: String, isbn: String)
    fun getOverdueBooks(): List<BorrowingRecord>
    fun returnBorrowRecords(borrowingRecords: List<BorrowingRecord>)
}