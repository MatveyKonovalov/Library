package org.example.data.di

import dagger.Component
import org.example.data.services.BookService
import javax.inject.Singleton

@Singleton
@Component(modules = [BookModule::class])
interface BookComponent{
    fun getBookService(): BookService
}