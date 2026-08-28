package org.example.domain.repositories

import org.example.domain.models.BorrowingRecord

interface BorrowingRecordOperations{
    fun deleteRecord(recordId: String): BorrowingRecord?
    fun getRecordById(recordId: String): BorrowingRecord?
    fun addRecord(record: BorrowingRecord)
    fun getAllRecords(): List<BorrowingRecord>
}