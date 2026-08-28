package org.example.data.di

import dagger.Component
import org.example.data.services.UserService

@Component(modules = [UserModule::class])
interface UserComponent {
    fun getUserService(): UserService
}