package domain.models

import org.example.domain.models.Book
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse


class BookTest {
    lateinit var bookWith0Amount: Book
    lateinit var bookWith1Amount: Book

    @BeforeEach
    fun initBook() {
        bookWith0Amount = Book("t1", "a1", "i1", "g1", 0)
        bookWith1Amount = Book("t2", "a2", "i2", "g2", 1)
    }

    @Test
    fun `check available when amount = 0`(){
        assertFalse(bookWith0Amount.isAvailable())

    }
    @Test
    fun `check available when amount != 0`(){
        assertTrue(bookWith1Amount.isAvailable())
    }

    @Test
    fun `take book when amount = 0`(){
        assertFalse(bookWith0Amount.takeBook())
    }

    @Test
    fun `take book when amount != 0`(){
        assertTrue(bookWith1Amount.takeBook()) // check available
        assertEquals(0, bookWith1Amount.getFreeAmount()) // check amount
    }

    @Test
    fun `reduce books when given amount lower than 0`(){
        assertFalse( bookWith1Amount.reduceBook(0))
        assertEquals(1, bookWith1Amount.getFreeAmount())

        assertFalse(bookWith1Amount.reduceBook(-1))
        assertEquals(1, bookWith1Amount.getFreeAmount())
    }

    @Test
    fun `reduce books when amount higher than 0 and lower than free amount book`(){
        assertTrue(bookWith1Amount.reduceBook(1))
        assertEquals(0, bookWith1Amount.getFreeAmount())
    }
    @Test
    fun `reduce books when amount higher than 0 and higher than free amount book`(){
        assertFalse(bookWith1Amount.reduceBook(10))
        assertEquals(1, bookWith1Amount.getFreeAmount())
    }

    @Test
    fun `plus books when given amount lower than 0`(){
        assertFalse( bookWith1Amount.plusBook(0))
        assertEquals(1, bookWith1Amount.getFreeAmount())

        assertFalse(bookWith1Amount.plusBook(-1))
        assertEquals(1, bookWith1Amount.getFreeAmount())
    }

    @Test
    fun `plus books when amount higher than 0`(){
        assertTrue(bookWith1Amount.plusBook(1))
        assertEquals(2, bookWith1Amount.getFreeAmount())
    }

    @Test
    fun `check free a,ount books`(){
        assertEquals(0, bookWith0Amount.getFreeAmount())
        assertEquals(1, bookWith1Amount.getFreeAmount())
    }
}