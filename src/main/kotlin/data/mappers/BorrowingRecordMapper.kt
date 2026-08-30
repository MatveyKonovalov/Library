package org.example.data.mappers

import org.example.data.entities.BorrowingRecordEntity
import org.example.domain.models.BorrowingRecord
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BorrowingRecordMapper @Inject constructor() {
    fun toBorrowingRecord(borrowingRecordEntity: BorrowingRecordEntity): BorrowingRecord {
        val date = borrowingRecordEntity.borrowingStartTime

        return BorrowingRecord(
            userId = borrowingRecordEntity.userId,
            isbn = borrowingRecordEntity.isbn,
            borrowDays = borrowingRecordEntity.borrowDays,
            borrowingStartTime = LocalDate.of(date[0], date[1], date[2]),
            fine = borrowingRecordEntity.fine
        )
    }

    fun toBorrowingRecordEntity(borrowingRecord: BorrowingRecord): BorrowingRecordEntity {
        val date = borrowingRecord.borrowingStartTime

        return BorrowingRecordEntity(
            userId = borrowingRecord.userId,
            isbn = borrowingRecord.isbn,
            borrowDays = borrowingRecord.borrowDays,
            borrowingStartTime = listOf(date.year, date.monthValue, date.dayOfMonth),
            fine = borrowingRecord.fine
        )
    }
}