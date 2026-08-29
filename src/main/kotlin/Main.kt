package org.example

import org.example.data.di.DaggerLibraryComponent
import org.example.presentation.UserConsoleUI

fun main() {
    val libraryFactory = DaggerLibraryComponent.create()
    val library = libraryFactory.getLibrary()

    val userConsoleUI = UserConsoleUI(library)
    userConsoleUI.libraryDialog()
}