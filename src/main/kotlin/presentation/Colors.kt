package org.example.presentation

enum class Colors(val command: String) {
    CYAN("\u001B[36m"), // Title app
    GREEN("\u001B[32m"), // Title chapter
    RED("\u001B[31m"), // Invalid Input

    RESET_COLORS("\u001B[0m")
}