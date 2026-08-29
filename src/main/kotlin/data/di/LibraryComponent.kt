package org.example.data.di

import dagger.Component
import org.example.data.Library
import javax.inject.Singleton

@Singleton
@Component(modules = [LibraryModule::class, BookModule::class, BorrowingRecordModule::class, UserModule::class])
interface LibraryComponent {
    fun getLibrary(): Library
}