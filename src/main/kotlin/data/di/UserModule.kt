package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.UserService
import org.example.domain.repositories.UserOperations
import javax.inject.Singleton

@Module
abstract class UserModule {
    @Binds
    @Singleton
    abstract fun bindUserService(impl: UserService): UserOperations
}