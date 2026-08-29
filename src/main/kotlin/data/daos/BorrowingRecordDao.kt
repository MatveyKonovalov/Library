package org.example.data.daos

import org.example.domain.models.BorrowingRecord
import org.example.domain.repositories.BorrowingRecordOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordDao @Inject constructor() {
    // key: recordId, value: BorrowingRecord
    private val borrowingRecords = mutableListOf<BorrowingRecord>()

    fun deleteRecord(userId: String, isbn: String): BorrowingRecord? {
        borrowingRecords.forEachIndexed { ind, borrowingRecord ->
            if (borrowingRecord.isbn == isbn && borrowingRecord.userId == userId) {
                borrowingRecords.removeAt(ind)
                return borrowingRecord
            }
        }
        return null
    }

    fun addRecord(record: BorrowingRecord) {
        borrowingRecords.add(record)
    }

    fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecords.sortedBy { borrowingRecord -> borrowingRecord.borrowingStartTime }
    }
}