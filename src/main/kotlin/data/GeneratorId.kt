package org.example.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeneratorId @Inject constructor() {
    private var bookId = 0L
    private var userId = 0L
    private var borrowingRecordId = 0L

    fun getBookId(): String{
        return (bookId++).toString()
    }
    fun getUserId(): String{
        return (userId++).toString()
    }
    fun getBorrowingRecordId(): String{
        return (borrowingRecordId++).toString()
    }
}