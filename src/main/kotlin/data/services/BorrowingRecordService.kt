package org.example.data.services

import org.example.data.daos.BorrowingRecordDao
import org.example.domain.models.BorrowingRecord
import org.example.domain.repositories.BorrowingRecordOperations
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordService @Inject constructor(private val borrowingRecordDao: BorrowingRecordDao) :
    BorrowingRecordOperations {
    override fun deleteRecord(userId: String, recordId: String): BorrowingRecord? {
        return borrowingRecordDao.deleteRecord(userId, recordId)
    }


    override fun addRecord(record: BorrowingRecord) {
        borrowingRecordDao.addRecord(record)
    }

    private fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecordDao.getAllRecords()
    }

    override fun getOverdueBooks(): List<BorrowingRecord> {
        return getAllRecords().filter { borrowingRecord ->
            val currentDate = LocalDate.now()
            val userBorrowDays = borrowingRecord.borrowDays.toLong()
            val startDate = borrowingRecord.borrowingStartTime

            currentDate > startDate.plusDays(userBorrowDays)
        }
    }

    override fun getAllRecordWithCurrentIsbn(isbn: String): List<BorrowingRecord> {
        return getAllRecords().filter{borrowingRecord ->  borrowingRecord.isbn == isbn}
    }
}