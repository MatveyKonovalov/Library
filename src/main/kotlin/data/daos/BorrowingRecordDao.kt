package org.example.data.daos

import org.example.domain.models.BorrowingRecord
import org.example.domain.repositories.BorrowingRecordOperations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordDao @Inject constructor() : BorrowingRecordOperations {
    // key: recordId, value: BorrowingRecord
    private val borrowingRecords = mutableMapOf<String, BorrowingRecord>()

    override fun deleteRecord(recordId: String): BorrowingRecord? {
        return borrowingRecords[recordId]
    }

    override fun getRecordById(recordId: String): BorrowingRecord? {
        return borrowingRecords[recordId]
    }

    override fun addRecord(record: BorrowingRecord) {
        if (borrowingRecords[record.recordId] != null) {
            throw IllegalArgumentException("Record with this recordId<${record.recordId}> already exists")
        }
        borrowingRecords[record.recordId] = record
    }

    override fun getAllRecords(): List<BorrowingRecord> {
        return borrowingRecords.values.sortedBy {borrowingRecord ->  borrowingRecord.borrowingStartTime}
    }
}