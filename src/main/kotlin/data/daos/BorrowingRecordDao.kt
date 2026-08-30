package org.example.data.daos

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.data.entities.BorrowingRecordEntity
import org.example.data.mappers.BorrowingRecordMapper
import org.example.domain.models.BorrowingRecord
import java.io.File
import java.io.FileNotFoundException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordDao @Inject constructor(private val borrowingRecordMapper: BorrowingRecordMapper) {
    companion object {
        private const val FILENAME = "borrowing_records.txt"
    }

    // key: recordId, value: BorrowingRecord
    private val borrowingRecords by lazy { loadBorrowingRecords().toMutableList() }

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

    fun saveBorrowingRecordsInFile() {
        val jsonList = Json.encodeToString(borrowingRecords.map { borrowingRecord ->
            borrowingRecordMapper.toBorrowingRecordEntity(borrowingRecord)
        })
        File(FILENAME).writeText(jsonList)
    }

    private fun loadBorrowingRecords(): List<BorrowingRecord> {
        return try {
            val jsonString = File(FILENAME).readText()
            Json.decodeFromString<List<BorrowingRecordEntity>>(jsonString)
                .map { borrowingRecordEntity -> borrowingRecordMapper.toBorrowingRecord(borrowingRecordEntity) }
        } catch (e: FileNotFoundException) {
            emptyList()
        }
    }

}