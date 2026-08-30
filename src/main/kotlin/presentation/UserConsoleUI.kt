package org.example.presentation

import org.example.domain.LibraryOperations
import org.example.domain.models.Book
import org.example.domain.models.BorrowingRecord
import org.example.domain.models.UserType
import java.security.KeyException
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.system.exitProcess

@Singleton
class UserConsoleUI @Inject constructor(private val libraryOperations: LibraryOperations) {
    companion object {
        private val ErrorFormatMessage =
            "${Colors.RED.command}Incorrect input. Enter a digit${Colors.RESET_COLORS.command}"
        private val ErrorCommandNumMessage =
            "${Colors.RED.command}Incorrect input. The Command is not found${Colors.RESET_COLORS.command}"
        private val ErrorAmountMessage =
            "${Colors.RED.command}Incorrect input.The quantity must be positive${Colors.RESET_COLORS}"
        private val ErrorAnswerForYesNoQuestionMessage =
            "${Colors.RED.command}Incorrect input. Enter yes or no${Colors.RESET_COLORS.command}"

        private fun makeRedColorText(text: String) = Colors.RED.command + text + Colors.RESET_COLORS.command
        private fun makeGreenColorText(text: String) = Colors.GREEN.command + text + Colors.RESET_COLORS.command
        private fun makeCyanColorText(text: String) = Colors.CYAN.command + text + Colors.RESET_COLORS.command
    }

    fun libraryDialog() {
        var numCommand = 4
        val defaultValue = 4
        val maxValue = 4
        while (true) {
            when (numCommand) {
                1 -> bookManagement()
                2 -> userManagement()
                3 -> borrowingOperations()
                4 -> showMenu()
                0 -> {
                    libraryOperations.saveInFile()
                    exitProcess(0)
                }
            }
            print("Enter next command: ")
            val userInputCheckResult = checkUserCommandInput(readln(), maxValue, defaultValue)
            numCommand = processingCheckUserInput(userInputCheckResult)
        }
    }

    // 1
    private fun bookManagement() {
        var userInput = 9
        val maxValue = 9
        val defaultValue = 9
        while (userInput != 0) {
            when (userInput) {
                1 -> addBook(isAddedSomeBooks = false)
                2 -> addBook(isAddedSomeBooks = true)
                3 -> reduceAmountBooks()
                4 -> removeBook()
                5 -> searchBookByISBN()
                6 -> searchBookByAuthor()
                7 -> searchBookByTitle()
                8 -> showAllBooks()
                9 -> bookManagementMenu()
            }
            print("Enter next command: ")
            val userInputCheckResult = checkUserCommandInput(readln(), maxValue, defaultValue)
            userInput = processingCheckUserInput(userInputCheckResult)
        }
        println("Exiting Book Management...")
        showMenu()
    }

    private fun bookManagementMenu() {
        println(makeGreenColorText("\n=== Book Management ==="))
        println("1. Add a book")
        println("2. Add some books")
        println("3. Reduce some books")
        println("4. Remove book (delete all books with current isbn)")
        println("5. Search a book by isbn")
        println("6. Search books by author")
        println("7. Search books by title")
        println("8. Show all books")
        println("9. Show Book Management Menu")
        println("0. Quit from Book Management")
    }

    private fun addBook(isAddedSomeBooks: Boolean) {
        val title = checkNoBlankInput("title")
        val author = checkNoBlankInput("author")
        val isbn = checkNoBlankInput("isbn")
        val genre = checkNoBlankInput("genre")
        var amount = 1
        if (isAddedSomeBooks) {
            amount = checkAmountInput("books")
        }
        libraryOperations.addBooks(title, author, isbn, genre, amount)
        println("The addition was successful. Books added: ${amount}\n")
    }

    private fun reduceAmountBooks() {
        val isbn = checkNoBlankInput("isbn")
        val amount = checkAmountInput("books")

        try {
            libraryOperations.reduceAmountBook(isbn, amount)
            println("Removed books: $amount")
        } catch (e: Exception) {
            println(Colors.RED.command + e.message + Colors.RESET_COLORS.command)
        }
    }

    private fun removeBook() {
        val isbn: String = checkNoBlankInput("isbn")
        var affectedRecords = emptyList<BorrowingRecord>()

        try {
            affectedRecords = libraryOperations.removeAllBook(isbn)
            if (affectedRecords.isNotEmpty()) {
                println("Delete all records with isbn=${isbn}? yes/no")
                val answer = getUserYesNoInput()
                if (answer == "yes") {
                    libraryOperations.returnBorrowRecords(affectedRecords)
                    println("All records with isbn=${isbn} were deleted")
                }

            }
            println("Book with isbn=$isbn was deleted")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun searchBookByISBN() {
        val isbn = checkNoBlankInput("isbn")

        try {
            val book = libraryOperations.findBookByIsbn(isbn)
            println("Book info: $book")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun searchBookByTitle() {
        val title = checkNoBlankInput("title")

        try {
            val book = libraryOperations.findBookByTitle(title)
            println("The found book: $book")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun searchBookByAuthor() {
        val author = checkNoBlankInput("author")
        val books = libraryOperations.findBookByAuthor(author)
        if (books.isEmpty()) {
            println("No books with author=$author were found")
        } else {
            println("Books: ")
            books.forEach { book ->
                println("\t$book")
            }
        }
        bookManagementMenu()
    }

    private fun showAllBooks() {
        val books: List<Book> = libraryOperations.getAllBooks()

        if (books.isEmpty()) {
            println("There are no books")
        } else {
            println("Books: ")
            books.forEach { println("\t$it") }
        }
        bookManagementMenu()
    }

    // 2
    private fun userManagement() {
        var userInput = 4
        val maxValue = 4
        val defaultValue = 4

        while (userInput != 0) {
            when (userInput) {
                1 -> registerUser()
                2 -> findUser()
                3 -> showAllUsers()
                4 -> userManagementMenu()
            }
            print("Enter next command: ")
            val userInputCheckResult = checkUserCommandInput(readln(), maxValue, defaultValue)
            userInput = processingCheckUserInput(userInputCheckResult)
        }
        println("Exiting User Management...")
        showMenu()
    }

    private fun userManagementMenu() {
        println(makeGreenColorText("\n=== User Management ==="))
        println("1. Register a new user")
        println("2. Find the user")
        println("3. Show all users")
        println("4. Show The User Management Menu")
        println("0. Quit from User Management")
    }

    private fun registerUser() {
        val name = checkNoBlankInput("name")
        val email = checkNoBlankInput("email")
        val type = getUserType()

        try {
            val id = libraryOperations.registerUser(name, email, type)
            println("The user has been added. UserId = $id")
        } catch (e: IllegalArgumentException) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun findUser() {
        val userId = checkNoBlankInput("userId")

        try {
            val user = libraryOperations.findUser(userId)
            println("User info: $user")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun showAllUsers() {
        val users = libraryOperations.getAllUsers()
        if (users.isEmpty()) {
            println("There are no users")
        } else {
            println("Users: ")
            users.forEach {
                println("\t$it")
            }
        }
    }

    // 3
    private fun borrowingOperations() {
        var userInput = 4
        val maxValue = 4
        val defaultValue = 4

        while (userInput != 0) {
            when (userInput) {
                1 -> borrowBook()
                2 -> returnBook()
                3 -> showOverdueBooks()
                4 -> borrowingOperationsMenu()
            }
            print("Enter next command: ")
            val userInputCheckResult = checkUserCommandInput(readln(), maxValue, defaultValue)
            userInput = processingCheckUserInput(userInputCheckResult)
        }
        println("Exiting Borrowing Operations...")
        showMenu()
    }

    private fun borrowingOperationsMenu() {
        println(makeGreenColorText("\n=== Borrowing Operations ==="))
        println("1. Borrow the book")
        println("2. Return the book")
        println("3. Get overdue books")
        println("4. Show The Borrowing Operations Menu")
        println("0. Quit from Borrowing Operations")
    }

    private fun borrowBook() {
        val isbn = checkNoBlankInput("ISBN")
        val userId = checkNoBlankInput("userId")

        try {
            libraryOperations.borrowBook(userId, isbn)
            println("A record has been created")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        } catch (e: Exception) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun returnBook() {
        val isbn = checkNoBlankInput("ISBN")
        val userId = checkNoBlankInput("userId")

        try {
            libraryOperations.returnBook(userId, isbn)
            println("A record has been deleted")
        } catch (e: KeyException) {
            println(makeRedColorText(e.message.toString()))
        } catch (e: Exception) {
            println(makeRedColorText(e.message.toString()))
        }
    }

    private fun showOverdueBooks() {
        val overdueBooksWithFine = libraryOperations.getOverdueBooksWithFine()

        if (overdueBooksWithFine.isEmpty()) {
            println("There are no overdue records")
        } else {
            println("Overdue records: ")
            overdueBooksWithFine.forEach { (overdueBookRecord, fine) ->
                println("\t$overdueBookRecord Fine: $fine")
            }
        }
    }

    // 4
    private fun showMenu() {
        println(makeCyanColorText("\n=== Library Management ==="))
        println("1. Book Management")
        println("2. User Management")
        println("3. Borrowing Operations")
        println("4. Show Menu")
        println("0. Exit")
    }

    // USEFUL FUNC
    private fun checkUserCommandInput(userInput: String, maxValue: Int, defaultValue: Int): Pair<Boolean, Int> {
        return try {
            val intInput = userInput.toInt()
            if (intInput in 0..maxValue) {
                true to intInput
            } else {
                false to defaultValue
            }

        } catch (_: NumberFormatException) {
            false to -1
        }
    }

    private fun processingCheckUserInput(pairResult: Pair<Boolean, Int>): Int {
        val (resultUserCheck, userCommand) = pairResult
        return if (!resultUserCheck && userCommand == -1) {
            println(ErrorFormatMessage)
            -1
        } else if (!resultUserCheck) {
            println(ErrorCommandNumMessage)
            -1
        } else {
            userCommand
        }
    }

    private fun checkNoBlankInput(message: String): String {
        val enterMessage = "Entry the $message: "
        print(enterMessage)
        var input = readln()
        while (input.isBlank()) {
            println("${Colors.RED.command}The $message cannot be empty${Colors.RESET_COLORS.command}")
            print(enterMessage)
            input = readln()
        }
        return input
    }

    private fun checkAmountInput(message: String): Int {
        val enterMessage = "Enter the quantity $message: "
        print(enterMessage)
        var input = readln()
        var amount: Int = 1

        while (true) {
            try {
                amount = input.toInt()
                if (amount <= 0) {
                    println(ErrorAmountMessage)
                } else {
                    break
                }
            } catch (e: NumberFormatException) {
                println(ErrorFormatMessage)
            }
            print(enterMessage)
            input = readln()
        }
        return amount
    }

    private fun getUserYesNoInput(): String {
        var userInput = readln().lowercase()
        while (userInput !in listOf("yes", "no")) {
            println(ErrorAnswerForYesNoQuestionMessage)

            print("Enter your answer: ")
            userInput = readln()
        }
        return userInput
    }

    private fun getUserType(): UserType {
        print("Entry a user type: 0 - Guest, 1 - Student, 2 - Faculty: ")
        val input = readln()
        var (result, numInput) = checkUserCommandInput(input, 2, 0)

        while (!result) {
            if (numInput == -1) {
                println(ErrorFormatMessage)
            } else {
                print(makeRedColorText("Incorrect input. The Type is not found"))
            }
            val pair = checkUserCommandInput(readln(), 2, 0)
            result = pair.first
            numInput = pair.second
        }
        return UserType.entries[numInput]
    }
}