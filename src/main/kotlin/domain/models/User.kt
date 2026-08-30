package org.example.domain.models

abstract class User(val name: String, val userId: String, email: String) {
    var email: String =
        if (email.checkEmailOnCorrect()) email else throw IllegalArgumentException("Incorrect email")
        private set(value: String) {
            if (value.checkEmailOnCorrect()) {
                field = value
            } else {
                throw IllegalArgumentException("Incorrect email: $value")
            }
        }

    // Keep isbn books
    private val _borrowedBooks: MutableList<String> = mutableListOf()
    val borrowedBooks: List<String> = _borrowedBooks

    abstract fun getMaxBooks(): Int
    abstract fun getBorrowDays(): Int
    abstract fun getFinePerDay(): Double

    fun canBorrow(): Boolean = borrowedBooks.size < getMaxBooks()

    fun takeBook(isbn: String): Boolean {
        if (canBorrow()) {
            _borrowedBooks.add(isbn)
            return true
        }
        return false
    }

    fun returnBook(isbn: String) {
        _borrowedBooks.remove(isbn)
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}(name=${name}, userId=${userId}, email=${email})"
    }

}

private fun String.checkEmailOnCorrect(): Boolean {
    return this.contains("@") // Simple check email
}