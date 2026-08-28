package org.example.data.services

import org.example.data.daos.BorrowingRecordDao
import org.example.domain.models.BorrowingRecord
import org.example.domain.repositories.BorrowingRecordOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordService @Inject constructor(private val borrowingRecordDao: BorrowingRecordDao) :
    BorrowingRecordOperations {
    override fun deleteRecord(recordId: String): BorrowingRecord? {
        return borrowingRecordDao.deleteRecord(recordId)
    }

    override fun getRecordById(recordId: String): BorrowingRecord? {
        return borrowingRecordDao.getRecordById(recordId)
    }

    override fun addRecord(record: BorrowingRecord) {
        borrowingRecordDao.addRecord(record)
    }

    override fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecordDao.getAllRecords()
    }
}