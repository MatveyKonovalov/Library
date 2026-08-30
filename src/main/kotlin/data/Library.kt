package org.example.data

import org.example.domain.LibraryOperations
import org.example.domain.models.*
import org.example.domain.repositories.BookOperations
import org.example.domain.repositories.BorrowingRecordOperations
import org.example.domain.repositories.UserOperations
import java.security.KeyException
import javax.inject.Inject

class Library @Inject constructor(
    private val bookService: BookOperations,
    private val userService: UserOperations,
    private val borrowingRecordService: BorrowingRecordOperations
) : LibraryOperations {
    // BOOKS MANAGEMENT
    override fun addBooks(
        title: String,
        author: String,
        isbn: String,
        genre: String,
        amount: Int
    ): Pair<Boolean, Book> { // Boolean - is it new book?
        return bookService.addBook(title, author, isbn, genre, amount)
    }

    override fun removeAllBook(isbn: String) {
        bookService.removeBook(isbn) ?: throw KeyException("Book(isbn=$isbn) is not found")
        val affectedRecords = borrowingRecordService.getAllRecordWithCurrentIsbn(isbn)
        returnBorrowRecords(affectedRecords)
    }

    override fun findBookByIsbn(isbn: String): Book {
        return bookService.findBookByIsbn(isbn) ?: throw KeyException("Book(isbn=$isbn) is not found")
    }

    override fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    override fun findBookByAuthor(author: String): List<Book> {
        return bookService.findBookByAuthor(author)
    }

    override fun findBookByTitle(title: String): List<Book> {
        return bookService.findBookByTitle(title)
    }

    override fun reduceAmountBook(isbn: String, amount: Int): Pair<Boolean, Int> {
        return bookService.reduceBookAmount(isbn, amount)
    }

    // USER MANAGEMENT
    override fun registerUser(name: String, email: String, userType: UserType): String {
        return userService.registerUser(name, email, userType)
    }

    override fun findUser(userId: String): User {
        return userService.findUser(userId) ?: throw KeyException("The user with userId=$userId is not found")
    }

    override fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    // BORROWING MANAGEMENT
    override fun borrowBook(userId: String, isbn: String) {
        val user = userService.findUser(userId)
        val book = bookService.findBookByIsbn(isbn)

        if (user == null) throw KeyException("There is no user with userid=${userId}")
        if (book == null) throw KeyException("There is no book with isbn=${isbn}")

        if (!user.canBorrow()) throw Exception("User userId=${userId} exceed the limit")
        if (!book.isAvailable()) throw Exception("Book is not available")

        val userResult = user.takeBook(isbn)
        val bookResult = book.takeBook()

        if (userResult && bookResult) {
            borrowingRecordService.addRecord(
                BorrowingRecord(
                    userId = userId,
                    isbn = isbn,
                    borrowDays = user.getBorrowDays(),
                    fine = user.getFinePerDay()
                )
            )
        }

    }

    override fun returnBook(userId: String, isbn: String) {
        val borrowingRecord = borrowingRecordService.getRecordByUserIdAndIsbn(userId, isbn)
            ?: throw KeyException("Record with userId=$userId isbn=$isbn is not found")

        val user = userService.findUser(borrowingRecord.userId)
        val book = bookService.findBookByIsbn(borrowingRecord.isbn)

        if (user == null) throw Exception("It looks like this user(userId=$userId) has been deleted")
        if (book == null) throw Exception("It looks like this book(bookId=$isbn) has been deleted")

        borrowingRecordService.deleteRecord(userId, isbn)
        book.plusBook()
        user.returnBook(isbn)
    }

    override fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>> {
        return borrowingRecordService.getOverdueBooksWithFine()
    }

    override fun borrowingRecordsWithThisBook(isbn: String): List<BorrowingRecord> {
        return borrowingRecordService.getAllRecordWithCurrentIsbn(isbn)
    }

    override fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecordService.getAllRecords()
    }


    override fun saveInFile() {
        bookService.saveInFile()
        userService.saveInFile()
        borrowingRecordService.saveInFile()
    }
    private fun returnBorrowRecords(borrowingRecords: List<BorrowingRecord>) {
        borrowingRecords.forEach { borrowingRecord ->
            borrowingRecordService.deleteRecord(
                borrowingRecord.userId,
                borrowingRecord.isbn
            )
            val user = userService.findUser(userId = borrowingRecord.userId)
            user?.returnBook(borrowingRecord.isbn)
        }
    }

}