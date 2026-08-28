package org.example.data.di

import dagger.Component
import org.example.data.services.BorrowingRecordService

@Component(modules = [BorrowingRecordModule::class])
interface BorrowingRecordComponent {
    fun getBorrowingRecordService(): BorrowingRecordService
}