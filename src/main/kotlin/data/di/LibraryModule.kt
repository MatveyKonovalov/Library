package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.Library
import org.example.domain.LibraryOperations
import javax.inject.Singleton

@Module
abstract class LibraryModule {
    @Binds
    @Singleton
    abstract fun bindLibrary(impl: Library): LibraryOperations
}