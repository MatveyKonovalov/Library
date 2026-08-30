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
    override fun addBooks(title: String, author: String, isbn: String, genre: String, amount: Int) {
        bookService.addBook(title, author, isbn, genre, amount)
    }

    override fun removeAllBook(isbn: String): List<BorrowingRecord> {
        bookService.removeBook(isbn) ?: throw KeyException("Book(isbn=$isbn) is not found")
        val affectedRecords = borrowingRecordService.getAllRecordWithCurrentIsbn(isbn)

        return affectedRecords
    }

    override fun returnBorrowRecords(borrowingRecords: List<BorrowingRecord>) {
        borrowingRecords.forEach { borrowingRecord ->
            borrowingRecordService.deleteRecord(
                borrowingRecord.userId,
                borrowingRecord.isbn
            )
        }
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

    override fun findBookByTitle(title: String): Book {
        return bookService.findBookByTitle(title) ?: throw KeyException("The Book(title=$title) is not found")
    }

    override fun reduceAmountBook(isbn: String, amount: Int) {
        bookService.reduceBookAmount(isbn, amount) ?: throw Exception("The Book with isbn is not found")
    }

    // USER MANAGEMENT
    override fun registerUser(name: String, userId: String, email: String, userType: UserType) {
        userService.registerUser(
            when (userType) {
                UserType.GUEST -> Guest(name, userId, email)
                UserType.STUDENT -> Student(name, userId, email)
                UserType.FACULTY -> Faculty(name, userId, email)
            }
        )
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
        val borrowingRecord = borrowingRecordService.deleteRecord(userId, isbn)
            ?: throw KeyException("Record with userId=$userId isbn=$isbn is not found")

        val user = userService.findUser(borrowingRecord.userId)
        val book = bookService.findBookByIsbn(borrowingRecord.isbn)

        if (user == null) throw Exception("It looks like this user(userId=$userId) has been deleted")
        if (book == null) throw Exception("It looks like this book(bookId=$isbn) has been deleted")

        book.plusBook()
        user.returnBook(isbn)
    }

    override fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>> {
        return borrowingRecordService.getOverdueBooksWithFine()
    }
}