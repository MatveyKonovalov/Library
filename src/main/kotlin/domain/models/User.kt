package org.example.domain.models

abstract class User(val name: String, val userId: String, email: String) {
    var email: String = email
        private set(value: String) {
            if (value.checkEmailOnCorrect()){
                field = value
            } else{
                throw IllegalArgumentException("Incorrect email: $value")
            }
        }


    private val _borrowedBooks: MutableList<Book> = mutableListOf()
    val borrowedBooks: List<Book> = _borrowedBooks

    abstract fun getMaxBooks(): Int
    abstract fun getBorrowDays(): Int
    abstract fun getFinePerDay(): Double
    fun canBorrow(): Boolean = borrowedBooks.size < getMaxBooks()

    override fun toString(): String {
        return "${this.javaClass.simpleName}(name=${name}, userId=${userId}, email=${email})"
    }
}

private fun String.checkEmailOnCorrect(): Boolean{
    return this.contains("@") // Simple check email
}