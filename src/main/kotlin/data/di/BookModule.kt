package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.BookService
import org.example.domain.repositories.BookOperations

import javax.inject.Singleton

@Module
abstract class BookModule {
    @Binds
    @Singleton
    abstract fun bindBookService(impl: BookService): BookOperations
}