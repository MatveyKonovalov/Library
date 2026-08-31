package data.mappers

import org.example.data.entities.BorrowingRecordEntity
import org.example.data.mappers.BorrowingRecordMapper
import org.example.domain.models.BorrowingRecord
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class BorrowingRecordMapperTest {
    private val borrowingRecord = BorrowingRecord(
        "u1", "i1", 7, 0.5,
        LocalDate.of(2005, 5, 5)
    )
    private val borrowingRecordEntity = BorrowingRecordEntity(
        "u1", "i1", 7,
        listOf(2005, 5, 5), 0.5
    )
    private val mapper = BorrowingRecordMapper()

    @Test
    fun `check toDomain`(){
        val testDomain = mapper.toBorrowingRecord(borrowingRecordEntity)

        assertEquals("u1", testDomain.userId)
        assertEquals("i1", testDomain.isbn)
        assertEquals(7, testDomain.borrowDays)
        assertEquals(0.5, testDomain.fine)
        assertEquals(LocalDate.of(2005, 5, 5), testDomain.borrowingStartTime)
    }

    @Test
    fun `check toEntity`(){
        val testEntity = mapper.toBorrowingRecordEntity(borrowingRecord)

        assertEquals("u1", testEntity.userId)
        assertEquals("i1", testEntity.isbn)
        assertEquals(7, testEntity.borrowDays)
        assertEquals(0.5, testEntity.fine)
        assertEquals(listOf(2005, 5, 5), testEntity.borrowingStartTime)
    }
}