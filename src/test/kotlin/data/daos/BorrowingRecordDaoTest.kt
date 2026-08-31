package data.daos

import org.example.data.daos.BorrowingRecordDao
import org.example.data.mappers.BorrowingRecordMapper
import org.example.domain.models.BorrowingRecord
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BorrowingRecordDaoTest {
    private lateinit var borrowingRecordDao: BorrowingRecordDao

    @BeforeEach
    fun initDao(){
        val mapper = BorrowingRecordMapper()
        borrowingRecordDao = BorrowingRecordDao(mapper)
    }

    @Test
    fun `check add record`(){
        val borrowingRecord = BorrowingRecord("", "", 7, 0.8)
        assertEquals(0, borrowingRecordDao.getAllRecords().size)

        borrowingRecordDao.addRecord(borrowingRecord)
        assertEquals(1, borrowingRecordDao.getAllRecords().size)
        assertEquals(borrowingRecord, borrowingRecordDao.getAllRecords().first())
    }

    @Test
    fun `check delete record`(){
        val borrowingRecord = BorrowingRecord("", "", 7, 0.8)

        borrowingRecordDao.addRecord(borrowingRecord)

        assertEquals(null, borrowingRecordDao.deleteRecord("incorrect", "incorrect"))
        assertEquals(borrowingRecord, borrowingRecordDao.deleteRecord("", ""))
    }
}