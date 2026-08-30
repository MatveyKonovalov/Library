package org.example.data.services

import org.example.data.daos.BorrowingRecordDao
import org.example.domain.models.BorrowingRecord
import org.example.domain.repositories.BorrowingRecordOperations
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordService @Inject constructor(private val borrowingRecordDao: BorrowingRecordDao) :
    BorrowingRecordOperations {
    override fun deleteRecord(userId: String, isbn: String): BorrowingRecord? {
        return borrowingRecordDao.deleteRecord(userId, isbn)
    }


    override fun addRecord(record: BorrowingRecord) {
        borrowingRecordDao.addRecord(record)
    }

    private fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecordDao.getAllRecords()
    }

    override fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>> {
        return getAllRecords().mapNotNull { borrowingRecord ->
            val currentDate = LocalDate.now()
            val dueDate = borrowingRecord.borrowingStartTime.plusDays(borrowingRecord.borrowDays.toLong())

            if (currentDate > dueDate) {
                val daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate)
                borrowingRecord to daysOverdue * borrowingRecord.fine
            } else {
                null
            }
        }
    }

    override fun getAllRecordWithCurrentIsbn(isbn: String): List<BorrowingRecord> {
        return getAllRecords().filter { borrowingRecord -> borrowingRecord.isbn == isbn }
    }

    override fun saveInFile() {
        borrowingRecordDao.saveBorrowingRecordsInFile()
    }
}