package data.services

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.example.data.daos.BorrowingRecordDao
import org.example.data.services.BorrowingRecordService
import org.example.domain.models.Book
import org.example.domain.models.BorrowingRecord
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class BorrowingRecordServiceTest {
    private val borrowingRecordDao = mockk<BorrowingRecordDao>()
    private val borrowingRecordService = BorrowingRecordService(borrowingRecordDao)

    @Test
    fun `check add record`() {
        val addedRecord = BorrowingRecord("", "", 7, 0.5)
        every { borrowingRecordDao.addRecord(addedRecord) } just Runs

        assertEquals(Unit, borrowingRecordService.addRecord(addedRecord))
    }

    @Test
    fun `check delete record`() {
        val deletedRecord = BorrowingRecord("", "", 7, 0.5)
        every { borrowingRecordDao.deleteRecord("incorrect", "incorrect") } returns null
        every { borrowingRecordDao.deleteRecord("correct", "correct") } returns deletedRecord

        assertEquals(null, borrowingRecordService.deleteRecord("incorrect", "incorrect"))
        assertEquals(deletedRecord, borrowingRecordService.deleteRecord("correct", "correct"))
    }

    @Test
    fun `check get all records`() {
        every { borrowingRecordDao.getAllRecords() } returns emptyList()

        assertEquals(emptyList(), borrowingRecordService.getAllRecords())
    }

    @Test
    fun `check save in file`() {
        every { borrowingRecordDao.saveBorrowingRecordsInFile() } just Runs

        assertEquals(Unit, borrowingRecordService.saveInFile())
    }

    @Test
    fun `check get Record By User Id and Isbn`() {
        val record = BorrowingRecord("correct", "correct", 14, 0.8)
        every { borrowingRecordDao.getAllRecords() } returns listOf(record)

        assertEquals(null, borrowingRecordService.getRecordByUserIdAndIsbn("incorrect", "correct"))
        assertEquals(null, borrowingRecordService.getRecordByUserIdAndIsbn("correct", "incorrect"))
        assertEquals(null, borrowingRecordService.getRecordByUserIdAndIsbn("incorrect", "incorrect"))
        assertEquals(record, borrowingRecordService.getRecordByUserIdAndIsbn("correct", "correct"))
    }

    @Test
    fun `check get All Record With Current Isbn`() {
        val records = listOf(
            BorrowingRecord("1", "correct", 12, 0.8),
            BorrowingRecord("2", "correct", 12, 0.8),
            BorrowingRecord("", "incorrect", 12, 0.8)
        )
        every { borrowingRecordDao.getAllRecords() } returns records
        val result = borrowingRecordService.getAllRecordWithCurrentIsbn("correct")
        assertEquals(2, result.size)
        assertEquals(records[0], result[0])
        assertEquals(records[1], result[1])
    }

    @Test
    fun `check get Overdue Books With Fine`() {
        val currentDate = LocalDate.now()

        val overdueRecord = BorrowingRecord("", "incorrect", 7, 0.8,
            currentDate.minusDays(8))

        val records = listOf(
            BorrowingRecord("1", "correct", 7, 0.8, currentDate.minusDays(7)),
            BorrowingRecord("2", "correct", 7, 0.8, currentDate.minusDays(6)),
            overdueRecord
        )
        every { borrowingRecordDao.getAllRecords() } returns records

        val result = borrowingRecordService.getOverdueBooksWithFine()
        println(result)
        assertEquals(1, result.size)
        assertEquals(overdueRecord, result[0].first)
        assertEquals(0.8, result[0].second, 0.001)
    }
}