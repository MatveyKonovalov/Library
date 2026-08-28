package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.BookService
import org.example.domain.repository.BookOperations

@Module
abstract class BookModule {
    @Binds
    abstract fun bindBookService(impl: BookService): BookOperations
}