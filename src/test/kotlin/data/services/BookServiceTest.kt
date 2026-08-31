package data.services

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.example.data.daos.BookDao
import org.example.data.services.BookService
import org.example.domain.models.Book
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BookServiceTest {
    private val bookDao = mockk<BookDao>()
    private val bookService = BookService(bookDao)

    @Test
    fun `check add book with amount`() {
        val newBook = Book("", "", "newbook", "-", 3)
        val oldBook = Book("", "", "bookinbd", "-", 2)
        every { bookDao.addBook("", "", "newbook", "-", 3) } returns (false to newBook)
        every { bookDao.addBook("", "", "bookinbd", "-", 2) } returns (true to oldBook)

        val resultNewBook =
            bookService.addBook(newBook.title, newBook.author, newBook.isbn, newBook.genre, newBook.getFreeAmount())
        assertFalse(resultNewBook.first)
        assertEquals(newBook, resultNewBook.second)

        val resultOldBook =
            bookService.addBook(oldBook.title, oldBook.author, oldBook.isbn, oldBook.genre, oldBook.getFreeAmount())
        assertTrue(resultOldBook.first)
        assertEquals(oldBook, resultOldBook.second)
    }

    @Test
    fun `check add book without amount`() {
        val newBook = Book("", "", "newbook", "-", 1)
        val oldBook = Book("", "", "bookinbd", "-", 2)
        every { bookDao.addBook("", "", "newbook", "-",1) } returns (false to newBook)
        every { bookDao.addBook("", "", "bookinbd", "-", 1) } returns (true to oldBook)

        val resultNewBook =
            bookService.addBook(newBook.title, newBook.author, newBook.isbn, newBook.genre)
        assertFalse(resultNewBook.first)
        assertEquals(newBook, resultNewBook.second)

        val resultOldBook =
            bookService.addBook(oldBook.title, oldBook.author, oldBook.isbn, oldBook.genre)
        assertTrue(resultOldBook.first)
        assertEquals(oldBook, resultOldBook.second)
    }

    @Test
    fun `check remove books`() {
        val removedBook = Book("", "", "rmBook", "-", 1)
        every { bookDao.removeBook("incorrect") } returns null
        every { bookDao.removeBook("rmBook") } returns removedBook

        assertEquals(null, bookService.removeBook("incorrect"))
        assertEquals(removedBook, bookService.removeBook("rmBook"))
    }

    @Test
    fun `check find book by isbn`() {
        val foundedBook = Book("", "", "find", "-", 1)
        every { bookDao.findBookByIsbn("incorrect") } returns null
        every { bookDao.findBookByIsbn("find") } returns foundedBook

        assertEquals(null, bookService.findBookByIsbn("incorrect"))
        assertEquals(foundedBook, bookService.findBookByIsbn("find"))
    }

    @Test
    fun `check find book by author`() {
        val foundedBook = Book("", "", "find", "-", 1)
        every { bookDao.findBookByAuthor("incorrect") } returns emptyList()
        every { bookDao.findBookByAuthor("find") } returns listOf(foundedBook)

        assertEquals(emptyList(), bookService.findBookByAuthor("incorrect"))
        assertEquals(listOf(foundedBook), bookService.findBookByAuthor("find"))
    }

    @Test
    fun `check find book by title`() {
        val foundedBook = Book("", "", "find", "-", 1)
        every { bookDao.findBookByTitle("incorrect") } returns emptyList()
        every { bookDao.findBookByTitle("find") } returns listOf(foundedBook)

        assertEquals(emptyList(), bookService.findBookByTitle("incorrect"))
        assertEquals(listOf(foundedBook), bookService.findBookByTitle("find"))
    }

    @Test
    fun `check save in file`() {
        every { bookDao.saveBooksInFile() } just Runs

        assertEquals(Unit, bookService.saveInFile())
    }

    @Test
    fun `check reduce amount books`() {
        val reducedBook = Book("", "", "correct", "-", 1)
        val noReducedBook = Book("", "", "incorrect", "-", 1)
        every { bookDao.reduceBookAmount("correct", 1) } returns (true to reducedBook.getFreeAmount())
        every { bookDao.reduceBookAmount("incorrect", 1) } returns (false to noReducedBook.getFreeAmount())

        val successResult = bookService.reduceBookAmount("correct", 1)
        assertTrue(successResult.first)
        assertEquals(1, successResult.second)

        val failedResult = bookService.reduceBookAmount("incorrect", 1)
        assertFalse(failedResult.first)
        assertEquals(1, failedResult.second)
    }

    @Test
    fun `check remove book`() {
        val returnedBook = Book("", "", "correct", "", 0)
        every { bookDao.removeBook("incorrect") } returns null
        every { bookDao.removeBook("correct") } returns returnedBook

        assertEquals(null, bookService.removeBook("incorrect"))
        assertEquals(returnedBook, bookService.removeBook("correct"))
    }

    @Test
    fun `check get all books`() {
        every { bookDao.getAllBooks() } returns emptyList()

        assertEquals(emptyList(), bookService.getAllBooks())
    }
}