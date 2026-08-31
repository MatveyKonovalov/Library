package domain.models

import org.example.domain.models.Faculty
import org.example.domain.models.Guest
import org.example.domain.models.Student
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UserTest {
    lateinit var student: Student
    lateinit var faculty: Faculty
    lateinit var guest: Guest
    private val isbn: String = "i1"

    @BeforeEach
    fun initUsers() {
        student = Student("s1", "0", "s@s")
        faculty = Faculty("f1", "1", "f@f")
        guest = Guest("g1", "2", "g@g")
    }

    @Test
    fun `check student settings`() {
        assertEquals(3, student.getMaxBooks())
        assertEquals(14, student.getBorrowDays())
        assertEquals(0.50, student.getFinePerDay(), 0.0001)
    }

    @Test
    fun `check guest settings`() {
        assertEquals(1, guest.getMaxBooks())
        assertEquals(7, guest.getBorrowDays())
        assertEquals(1.50, guest.getFinePerDay(), 0.0001)
    }

    @Test
    fun `check faculty settings`() {
        assertEquals(10, faculty.getMaxBooks())
        assertEquals(30, faculty.getBorrowDays())
        assertEquals(0.30, faculty.getFinePerDay(), 0.0001)
    }

    @Test
    fun `check can borrow when len(borrowedBooks) lower than maxBorrow`() {
        // check guest
        assertTrue(guest.canBorrow())

        // check student
        assertTrue(student.canBorrow())
        student.takeBook(isbn)
        assertTrue(student.canBorrow())
        student.takeBook(isbn)
        assertTrue(student.canBorrow())

        // check faculty
        assertTrue(faculty.canBorrow())
        (0..8).forEach { _ -> faculty.takeBook(isbn) }
        assertTrue(faculty.canBorrow())

    }

    @Test
    fun `check can borrow when len(borrowedBooks) higher than maxBorrow`() {
        // check guest
        guest.takeBook(isbn)
        assertFalse(guest.canBorrow())

        // check student
        student.takeBook(isbn)
        student.takeBook(isbn)
        student.takeBook(isbn)
        assertFalse(student.canBorrow())

        // check faculty
        (0..9).forEach { _ -> faculty.takeBook(isbn) }
        assertFalse(faculty.canBorrow())
    }

    @Test
    fun `check borrow book`() {
        // check guest
        assertTrue(guest.takeBook(isbn))
        assertFalse(guest.takeBook(isbn))

        // check student
        assertTrue(student.takeBook(isbn))
        assertTrue(student.takeBook(isbn))
        assertTrue(student.takeBook(isbn))
        assertFalse(student.takeBook(isbn))

        // check faculty
        (0..9).forEach { _ -> assertTrue(faculty.takeBook(isbn)) }
        assertFalse(faculty.takeBook(isbn))
    }

    @Test
    fun `check incorrect email in constructor`(){
        assertThrows<IllegalArgumentException>{
            Guest("u1", "4", "")
        }
        assertThrows<IllegalArgumentException>{
            Faculty("u1", "4", "")
        }
        assertThrows<IllegalArgumentException>{
            Student("u1", "4", "")
        }


    }
    @Test
    fun `check correct email in constructor`(){
        Guest("u1", "4", "a@")
        Student("u1", "4", "a@")
        Faculty("u1", "4", "a@")
    }

    @Test
    fun `check return book`(){
        guest.takeBook(isbn)
        student.takeBook(isbn)
        faculty.takeBook(isbn)

        // if we entry incorrect isbn
        guest.returnBook("incorrect")
        assertEquals(1, guest.borrowedBooks.size)
        student.returnBook("incorrect")
        assertEquals(1, student.borrowedBooks.size)
        faculty.returnBook("incorrect")
        assertEquals(1, faculty.borrowedBooks.size)

        // if we entry correct isbn
        guest.returnBook(isbn)
        assertEquals(0, guest.borrowedBooks.size)
        student.returnBook(isbn)
        assertEquals(0, student.borrowedBooks.size)
        faculty.returnBook(isbn)
        assertEquals(0, faculty.borrowedBooks.size)
    }

    @Test
    fun `check to string`(){
        assertEquals("Guest(name=g1, userId=2, email=g@g)", guest.toString())
        assertEquals("Student(name=s1, userId=0, email=s@s)", student.toString())
        assertEquals("Faculty(name=f1, userId=1, email=f@f)", faculty.toString())
    }


}