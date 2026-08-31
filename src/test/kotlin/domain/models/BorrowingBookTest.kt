package domain.models

import org.example.domain.models.BorrowingRecord
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class BorrowingBookTest {
    private val record1 = BorrowingRecord("u1", "i1", 7,
        0.5, LocalDate.of(2021, 1, 1))

    @Test
    fun `check data`(){
        assertEquals("u1", record1.userId)
        assertEquals("i1", record1.isbn)
        assertEquals(7, record1.borrowDays)
        assertEquals(0.5, record1.fine, 0.001)
        assertEquals(LocalDate.of(2021, 1, 1), record1.borrowingStartTime)
    }

}