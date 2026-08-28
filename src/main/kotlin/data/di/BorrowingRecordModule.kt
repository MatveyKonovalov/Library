package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.BorrowingRecordService
import org.example.domain.repositories.BorrowingRecordOperations

@Module
abstract class BorrowingRecordModule {
    @Binds
    abstract fun bindBorrowingRecordService(impl: BorrowingRecordService): BorrowingRecordOperations
}