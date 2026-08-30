package org.example.domain.repositories

import org.example.domain.models.BorrowingRecord

interface BorrowingRecordOperations{
    fun deleteRecord(userId: String, isbn: String): BorrowingRecord?
    fun addRecord(record: BorrowingRecord)
    fun getOverdueBooksWithFine(): List<Pair<BorrowingRecord, Double>>
    fun getAllRecordWithCurrentIsbn(isbn: String): List<BorrowingRecord>
}