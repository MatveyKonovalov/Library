package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.BorrowingRecordService
import org.example.domain.repositories.BorrowingRecordOperations
import javax.inject.Singleton

@Module
abstract class BorrowingRecordModule {
    @Binds
    @Singleton
    abstract fun bindBorrowingRecordService(impl: BorrowingRecordService): BorrowingRecordOperations
}