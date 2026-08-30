package org.example.domain


import org.example.domain.models.*

interface LibraryOperations {
    // Book management
    fun addBooks(title: String, author: String, isbn: String, genre: String, amount: Int): Pair<Boolean, Book>
    fun removeAllBook(isbn: String)
    fun findBookByIsbn(isbn: String): Book
    fun reduceAmountBook(isbn: String, amount: Int): Pair<Boolean, Int>
    fun getAllBooks(): List<Book>
    fun findBookByAuthor(author: String): List<Book>
    fun findBookByTitle(title: String): List<Book>

    // User Management
    fun registerUser(name: String, email: String, userType: UserType): String // return back id
    fun findUser(userId: String): User
    fun getAllUsers(): List<User>

    // Borrowing operations
    fun borrowBook(userId: String, isbn: String)
    fun returnBook(userId: String, isbn: String)
    fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>>
    fun borrowingRecordsWithThisBook(isbn: String): List<BorrowingRecord>
    fun getAllRecords(): List<BorrowingRecord>
    fun saveInFile()
}