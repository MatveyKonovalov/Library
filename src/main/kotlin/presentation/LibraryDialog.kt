package org.example.presentation

import kotlin.system.exitProcess

fun libraryDialog() {
    var numCommand = 4
    var incorrectInput = false
    while (true) {
        when (numCommand) {
            1 -> {}
            2 -> {}
            3 -> {}
            4 -> showMenu()
            0 -> System.exit(0)
            else -> println("Undefined number command")
        }
        if (incorrectInput) println("Incorrect input. Enter a digit")

        runCatching {
            numCommand = readln().toInt()
        }.onFailure {
            numCommand = 4
            incorrectInput = true
        }.onSuccess {
            incorrectInput = false
        }
    }
}

private fun showMenu() {
    println("\n=== Library Management ===")
    println("1. Book Management")
    println("2. User Management")
    println("3. Borrowing Operations")
    println("4. Show Menu")
    println("0. Exit")
}