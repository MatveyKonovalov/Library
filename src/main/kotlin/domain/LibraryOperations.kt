package org.example.domain


import org.example.domain.models.*

interface LibraryOperations {
    // Book management
    fun addBook(title: String, author: String, isbn: String, genre: String)
    fun removeAllBook(isbn: String): List<BorrowingRecord>
    fun findBook(isbn: String): Book?
    fun reduceAmountBook(isbn: String, amount: Int)

    // User Management
    fun registerUser(name: String, userId: String, email: String, userType: UserType)
    fun findUser(userId: String): User?

    // Borrowing operations
    fun borrowBook(userId: String, isbn: String)
    fun returnBook(userId: String, isbn: String)
    fun getOverdueBooks(): List<BorrowingRecord>
    fun returnBorrowRecords(borrowingRecords: List<BorrowingRecord>)
}