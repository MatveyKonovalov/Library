package org.example.domain.repositories

import org.example.domain.models.BorrowingRecord

interface BorrowingRecordOperations{
    fun deleteRecord(userId: String, recordId: String): BorrowingRecord?
    fun addRecord(record: BorrowingRecord)
    fun getOverdueBooks(): List<BorrowingRecord>
    fun getAllRecordWithCurrentIsbn(isbn: String): List<BorrowingRecord>
}