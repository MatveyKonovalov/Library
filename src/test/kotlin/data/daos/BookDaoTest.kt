package data.daos

import org.example.data.daos.BookDao
import org.example.domain.models.Book
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import java.nio.file.Files
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Before test delete file user.txt
class BookDaoTest {
    private lateinit var bookDao: BookDao

    @BeforeEach
    fun initBookDao() {
        bookDao = BookDao()
        bookDao.getAllBooks() // load all books
    }

    @Test
    fun `find book`() {
        val testBook = Book("", "", "", "", 1)
        bookDao.addBook("", "", "", "", 1)

        // check by isbn
        assertEquals(testBook, bookDao.findBookByIsbn(""))
        assertEquals(null, bookDao.findBookByIsbn("incorrect"))

        // check by title
        assertEquals(listOf(testBook), bookDao.findBookByTitle(""))
        assertEquals(listOf(), bookDao.findBookByTitle("incorrect"))

        // check by author
        assertEquals(listOf(testBook), bookDao.findBookByAuthor(""))
        assertEquals(listOf(), bookDao.findBookByAuthor("incorrect"))
    }

    @Test
    fun `reduce book amount with undefined isbn`() {
        val testBook = Book("", "a1", "i1", "-", 10)
        bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())

        assertThrows<IllegalArgumentException> { // check incorrect
            bookDao.reduceBookAmount("incorrect", 10)
        }
    }

    @Test
    fun `reduce book amount with amount lower than book freeAmount`() {
        val testBook = Book("", "a1", "i1", "-", 10)
        bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())

        val result = bookDao.reduceBookAmount("i1", 10)
        assertTrue(result.first)
        assertEquals(0, result.second)
    }

    @Test
    fun `reduce book amount with amount higher than book freeAmount`() {
        val testBook = Book("", "a1", "i1", "-", 10)
        bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())

        val result = bookDao.reduceBookAmount("i1", 11)
        assertFalse(result.first)
        assertEquals(10, result.second)
    }

    @Test
    fun `check get all books`() {
        val testBook = Book("", "a1", "i1", "-", 10)
        bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())

        assertEquals(listOf(testBook), bookDao.getAllBooks())
    }

    @Test
    fun `check add book`() {
        val testBook = Book("", "a1", "i1", "-", 10)
        // first add
        val result =
            bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())
        assertFalse(result.first)
        assertEquals(testBook, result.second)

        //second add
        val result2 =
            bookDao.addBook(testBook.title, testBook.author, testBook.isbn, testBook.genre, testBook.getFreeAmount())
        assertTrue(result2.first)
        assertEquals(testBook.copy(freeAmount = 20), result2.second)

    }
}