package org.example.data.di

import dagger.Component
import org.example.data.services.UserService
import javax.inject.Singleton

@Singleton
@Component(modules = [UserModule::class])
interface UserComponent {
    fun getUserService(): UserService
}