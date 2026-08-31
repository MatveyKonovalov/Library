package data

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.example.data.Library
import org.example.data.services.BookService
import org.example.data.services.BorrowingRecordService
import org.example.data.services.UserService
import org.example.domain.models.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.security.KeyException
import java.sql.DataTruncation
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LibraryTest {
    private val bookService = mockk<BookService>()
    private val userService = mockk<UserService>()
    private val borrowingRecordService = mockk<BorrowingRecordService>()
    private val library = Library(bookService, userService, borrowingRecordService)

    // BOOK MANAGEMENT
    @Test
    fun `check add book`() {
        val oldBook = Book("", "", "oldBook", "", 2)
        val newBook = Book("", "", "newBook", "", 1)
        every { bookService.addBook("", "", "oldBook", "", 2) } returns (false to oldBook)
        every { bookService.addBook("", "", "newBook", "", 1) } returns (true to newBook)

        val resultNew =
            library.addBooks(newBook.title, newBook.author, newBook.isbn, newBook.genre, newBook.getFreeAmount())
        assertTrue(resultNew.first)
        assertEquals(newBook, resultNew.second)

        val resultOld =
            library.addBooks(oldBook.title, oldBook.author, oldBook.isbn, oldBook.genre, oldBook.getFreeAmount())
        assertFalse(resultOld.first)
        assertEquals(oldBook, resultOld.second)
    }

    @Test
    fun `remove all book`() {
        val book = Book("", "", "", "", 1)
        every { bookService.removeBook("incorrect") } returns null
        every { bookService.removeBook("correct") } returns book
        every { borrowingRecordService.getAllRecordWithCurrentIsbn("correct") } returns emptyList()
        assertThrows<KeyException> {
            library.removeAllBook("incorrect")
        }
        assertEquals(Unit, library.removeAllBook("correct"))
    }

    @Test
    fun `check find book by isbn`() {
        val foundedBook = Book("t1", "a1", "i1", "-", 1)
        every { bookService.findBookByIsbn("i1") } returns foundedBook
        every { bookService.findBookByIsbn("incorrect") } returns null

        assertThrows<KeyException> {
            library.findBookByIsbn("incorrect")
        }
        assertEquals(foundedBook, library.findBookByIsbn("i1"))
    }

    @Test
    fun `check find book by author`() {
        val foundedBook = Book("t1", "a1", "i1", "-", 1)
        every { bookService.findBookByAuthor("a1") } returns listOf(foundedBook)
        every { bookService.findBookByAuthor("incorrect") } returns emptyList()

        assertEquals(emptyList(), library.findBookByAuthor("incorrect"))
        assertEquals(listOf(foundedBook), library.findBookByAuthor("a1"))
    }

    @Test
    fun `check find book by title`() {
        val foundedBook = Book("t1", "a1", "i1", "-", 1)
        every { bookService.findBookByTitle("t1") } returns listOf(foundedBook)
        every { bookService.findBookByTitle("incorrect") } returns emptyList()

        assertEquals(emptyList(), library.findBookByTitle("incorrect"))
        assertEquals(listOf(foundedBook), library.findBookByTitle("t1"))
    }

    @Test
    fun `check get all books`() {
        every { bookService.getAllBooks() } returns emptyList()

        assertEquals(emptyList(), library.getAllBooks())
    }

    @Test
    fun `check reduce amount book`() {
        val successReduce = (true to 1)
        val failedReduce = (false to 1)
        every { bookService.reduceBookAmount("correct", 1) } returns successReduce
        every { bookService.reduceBookAmount("incorrect", 1) } returns failedReduce

        assertEquals(successReduce, library.reduceAmountBook("correct", 1))
        assertEquals(failedReduce, library.reduceAmountBook("incorrect", 1))
    }

    // USER MANAGEMENT
    @Test
    fun `check register user`() {
        every { userService.registerUser("", "incorrect", UserType.GUEST) } throws IllegalArgumentException()
        assertThrows<IllegalArgumentException> {
            library.registerUser("", "incorrect", UserType.GUEST)
        }
        every { userService.registerUser("", "c@", UserType.GUEST) } returns "0"
        assertEquals("0", library.registerUser("", "c@", UserType.GUEST))
    }

    @Test
    fun `check find user`() {
        every { userService.findUser("incorrect") } throws KeyException()
        val u1 = Guest("", "correct", "@")
        every { userService.findUser("correct") } returns u1

        assertThrows<KeyException> {
            library.findUser("incorrect")
        }
        assertEquals(u1, library.findUser("correct"))
    }

    @Test
    fun `check get all users`() {
        val users = emptyList<User>()
        every { userService.getAllUsers() } returns users

        assertEquals(users, library.getAllUsers())
    }
    // Borrowing operations
    @Test
    fun `check borrow book`() {
        val userCanBorrow = Guest("", "correctCanBorrow", "@")
        val bookCanTake = Book("", "", "correctCanTake", "")

        val userCannotBorrow = Guest("", "correctCannotBorrow", "@")
        userCannotBorrow.takeBook("t1")
        val bookCannotTake = Book("", "", "correctCannotTake", "", 1)
        val borrowingRecord = BorrowingRecord(
            "correctCanBorrow", "correctCanTake", 14, 0.5,
            LocalDate.of(2026, 9, 1)
        )

        every { userService.findUser("correctCanBorrow") } returns userCanBorrow
        every { bookService.findBookByIsbn("correctCanTake") } returns bookCanTake
        every { userService.findUser("correctCannotBorrow") } returns userCannotBorrow
        every { bookService.findBookByIsbn("correctCannotTake") } returns bookCannotTake
        every { userService.findUser("incorrect") } returns null
        every { bookService.findBookByIsbn("incorrect") } returns null
        every { borrowingRecordService.addRecord(borrowingRecord) } just Runs

        assertThrows<KeyException> {
            library.borrowBook("incorrect", "incorrect")
        }
        assertThrows<KeyException> {
            library.borrowBook("correctCanBorrow", "incorrect")
        }
        assertThrows<KeyException> {
            library.borrowBook("incorrect", "correctCanTake")
        }


        assertThrows<Exception> {
            library.borrowBook("correctCanBorrow", "correctCannotTake")
        }
        assertThrows<Exception> {
            library.borrowBook("correctCannotBorrow", "correctCannotTake")
        }
        assertThrows<Exception> {
            library.borrowBook("correctCannotBorrow", "correctCanTake")
        }

    }

    @Test
    fun `check save in file`() {
        every { bookService.saveInFile() } just Runs
        every { userService.saveInFile() } just Runs
        every { borrowingRecordService.saveInFile() } just Runs

        assertEquals(Unit, library.saveInFile())

    }

    @Test
    fun `check get all records`() {
        every { borrowingRecordService.getAllRecords() } returns emptyList()
        assertEquals(emptyList(), library.getAllRecords())
    }

    @Test
    fun `check borrowing records with this book`() {
        every { borrowingRecordService.getAllRecordWithCurrentIsbn("i1") } returns emptyList()

        assertEquals(emptyList(), library.borrowingRecordsWithThisBook("i1"))
    }

    @Test
    fun `check get overdue books with fine`() {
        val pairs = listOf(
            BorrowingRecord(
                "",
                "",
                7,
                0.6
            ) to 0.9
        )
        every { borrowingRecordService.getOverdueBooksWithFine() } returns pairs

        assertEquals(pairs, library.getOverdueBooksWithFine())
    }
}