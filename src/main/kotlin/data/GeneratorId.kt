package org.example.data

import javax.inject.Inject
import javax.inject.Singleton


object GeneratorId  {
    private var userId = 0L

    fun getUserId(): String{
        return (userId++).toString()
    }
}