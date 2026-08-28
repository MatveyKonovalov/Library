package org.example.data.di

import dagger.Binds
import dagger.Module
import org.example.data.services.UserService
import org.example.domain.repositories.UserOperations

@Module
abstract class UserModule {
    @Binds
    abstract fun bindUserService(impl: UserService): UserOperations
}